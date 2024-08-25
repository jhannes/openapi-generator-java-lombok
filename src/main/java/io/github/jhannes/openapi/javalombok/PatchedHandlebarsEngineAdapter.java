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
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

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
        handlebars.registerHelper("notMixinDto", new NotMixinDto());
        handlebars.registerHelper("isMixinAllOf", new IsMixinAllOf());
        handlebars.prettyPrint(true);
        Template tmpl = handlebars.compile(templateFile);
        return tmpl.apply(context);
    }

    public static abstract class ConditionalModelHelper implements Helper<Object> {
        @Override
        public Object apply(Object context, Options options) throws IOException {
            var result = getResult((CodegenModel)options.context.model());
            if (options.tagType == TagType.SECTION) {
                return result ? options.fn() : options.inverse();
            }
            return result
                    ? options.hash("yes", true)
                    : options.hash("no", false);
        }

        protected abstract boolean getResult(CodegenModel model);
    }

    public static class NotMixinDto extends ConditionalModelHelper {

        protected boolean getResult(CodegenModel codegenModel) {
            return !(codegenModel.interfaceModels.size() == 1 &&
                     Objects.equals(codegenModel.interfaceModels.getFirst().name, codegenModel.name));
        }
    }

    public static class IsMixinAllOf extends ConditionalModelHelper {
        @Override
        protected boolean getResult(CodegenModel model) {
            return model.interfaceModels.size() > 1 &&
                   model.interfaceModels.stream().anyMatch(m -> m.classname.endsWith("Interface"));
        }
    }
}
