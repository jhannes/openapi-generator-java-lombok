package io.github.jhannes.openapi.javalombok;

import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Jackson2Helper;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.TagType;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.context.FieldValueResolver;
import com.github.jknack.handlebars.context.JavaBeanValueResolver;
import com.github.jknack.handlebars.context.MapValueResolver;
import com.github.jknack.handlebars.helper.ConditionalHelpers;
import com.github.jknack.handlebars.helper.StringHelpers;
import com.github.jknack.handlebars.io.AbstractTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import com.github.jknack.handlebars.io.TemplateSource;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.api.TemplatingExecutor;
import org.openapitools.codegen.templating.HandlebarsEngineAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * TODO: This fixes a problem in Handlebars 4.2.0 with Java 17. Try to remove it when 1:handlebars:4.4.0 is released
 * `com.github.jknack.handlebars.HandlebarsException: baseApi.handlebars:4:3: java.lang.IllegalStateException: Shouldn't be illegal to access field 'size'`.
 */
class PatchedHandlebarsEngineAdapter extends HandlebarsEngineAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatchedHandlebarsEngineAdapter.class);

    public static class MyFieldValueResolver extends FieldValueResolver {

        @Override
        public boolean matches(FieldWrapper field, String name) {
            return super.matches(field, name) && !isTransient(field);
        }

        protected boolean isTransient(FieldWrapper member) {
            return Modifier.isTransient(member.getModifiers());
        }
    }

    @Override
    public String compileTemplate(TemplatingExecutor executor, Map<String, Object> bundle, String templateFile) throws IOException {
        TemplateLoader loader = new AbstractTemplateLoader() {
            @Override
            public TemplateSource sourceAt(String location) {
                return findTemplate(executor, location);
            }
        };

        Context context = Context
                .newBuilder(bundle)
                .resolver(
                        MapValueResolver.INSTANCE,
                        JavaBeanValueResolver.INSTANCE,
                        new MyFieldValueResolver())
                .build();

        Handlebars handlebars = new Handlebars(loader);
        handlebars.registerHelperMissing((obj, options) -> {
            LOGGER.warn(String.format(Locale.ROOT, "Unregistered helper name '%s', processing template:%n%s", options.helperName, options.fn.text()));
            return "";
        });
        handlebars.registerHelper("json", Jackson2Helper.INSTANCE);
        StringHelpers.register(handlebars);
        handlebars.registerHelpers(ConditionalHelpers.class);
        handlebars.registerHelpers(org.openapitools.codegen.templating.handlebars.StringHelpers.class);
        handlebars.registerHelper("implementations", new ImplementationsHelper());
        handlebars.registerHelper("ambiguousRelatedTypes", new AmbiguousRelatedTypesHelper());
        handlebars.registerHelper("isMixinAllOf", new IsMixinAllOf());
        handlebars.registerHelper("notMixinDto", new NotMixinDto());
        handlebars.prettyPrint(true);
        Template tmpl = handlebars.compile(templateFile);
        return tmpl.apply(context);
    }

    public static abstract class ConditionalModelHelper implements Helper<Object> {
        @Override
        public Object apply(Object context, Options options) throws IOException {
            var result = getResult((CodegenModel) options.context.model());
            if (options.tagType == TagType.SECTION) {
                return result ? options.fn() : options.inverse();
            }
            return result
                    ? options.hash("yes", true)
                    : options.hash("no", false);
        }

        protected abstract boolean getResult(CodegenModel model);
    }

    public static class AmbiguousRelatedTypesHelper implements Helper<Object> {
        @Override
        public Object apply(Object context, Options options) throws IOException {
            if (context instanceof CodegenModel model) {
                int index = 0;
                for (CodegenModel interfaceModel : values(model)) {
                    outputWithNewContext(options, interfaceModel, index++);
                }
            }
            return options.inverse();
        }

        private Collection<CodegenModel> values(CodegenModel model) {
            var result = new TreeMap<String, CodegenModel>();

            var encounteredTypes  = new TreeSet<String>();
            for (var interfaceModel : model.getInterfaceModels()) {
                for (var descendant : getDescendants(interfaceModel).values()) {
                    if (encounteredTypes.contains(descendant.name)) {
                        result.put(descendant.name, descendant);
                    }
                    encounteredTypes.add(descendant.name);
                }
            }
            result.remove(model.name);
            return result.values();
        }
    }

    public static class ImplementationsHelper implements Helper<Object> {

        @Override
        public Object apply(Object context, Options options) throws IOException {
            if (context instanceof CodegenModel model) {
                int index = 0;
                for (var interfaceModel : getDescendants(model).values()) {
                    outputWithNewContext(options, interfaceModel, index++);
                }
            }
            return options.inverse();
        }

    }

    public static class NotMixinDto extends ConditionalModelHelper {

        protected boolean getResult(CodegenModel model) {
            return !isMixinDto(model);
        }
    }

    public static class IsMixinAllOf extends ConditionalModelHelper {
        @Override
        protected boolean getResult(CodegenModel model) {
            return !isMixinDto(model) &&
                   ((model.interfaceModels.size() > 1 && implementsMixin(model))
                    || (model.parentModel != null && implementsMixin(model.parentModel)));
        }
    }

    private static boolean implementsMixin(CodegenModel model) {
        return model.interfaceModels.stream().anyMatch(PatchedHandlebarsEngineAdapter::isMixin);
    }

    private static boolean isMixin(CodegenModel m) {
        return m.classname.endsWith("Interface");
    }

    private static boolean isMixinDto(CodegenModel codegenModel) {
        return codegenModel.interfaceModels.size() == 1 &&
               Objects.equals(codegenModel.interfaceModels.getFirst().name, codegenModel.name);
    }

    private static Map<String, CodegenModel> getDescendants(CodegenModel model) {
        var result = new TreeMap<String, CodegenModel>();
        for (var child : model.children) {
            if ((child.interfaces.size() == 1 && child.interfaces.getFirst().equals(child.getName() + "Interface"))) {
                result.put(child.name, child.interfaceModels.getFirst());
            } else if (child.oneOf.isEmpty()) {
                result.put(child.name, child);
            }
            result.putAll(getDescendants(child));
        }
        return result;
    }

    private static void outputWithNewContext(Options options, Object newContext, int index) throws IOException {
        Context itCtx = Context.newContext(options.context, newContext)
                .combine("@key", index)
                .combine("@index", index)
                .combine("@first", index == (int) options.hash("base", 0) ? "first" : "")
                .combine("@odd", index % 2 == 0 ? "" : "odd")
                .combine("@even", index % 2 != 0 ? "even" : "")
                .combine("@index_1", index + 1);
        options.buffer().append(options.apply(options.fn, itCtx, Arrays.asList(newContext, index)));
    }

}
