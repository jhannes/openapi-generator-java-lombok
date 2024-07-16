package io.github.jhannes.openapi.javalombok;

import io.swagger.v3.oas.models.media.Schema;
import org.openapitools.codegen.CodegenConstants;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;
import org.openapitools.codegen.api.TemplatingEngineAdapter;
import org.openapitools.codegen.languages.AbstractJavaCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;

import java.util.HashMap;
import java.util.Map;

public class JavaCodegen extends AbstractJavaCodegen {

    public JavaCodegen() {
        templateDir = "JavaLombok";
        super.setTemplatingEngine(new PatchedHandlebarsEngineAdapter());

        apiDocTemplateFiles.clear();
        apiTestTemplateFiles.clear();
        modelTestTemplateFiles.clear();
        modelDocTemplateFiles.clear();
    }

    @Override
    public CodegenModel fromModel(String name, Schema model) {
        CodegenModel cm = super.fromModel(name, model);
        cm.imports.remove("ApiModel");
        cm.imports.remove("ApiModelProperty");
        return cm;
    }

    @Override
    public void processOpts() {
        if (!additionalProperties.containsKey(CodegenConstants.PACKAGE_NAME)) {
            additionalProperties.put(CodegenConstants.PACKAGE_NAME, "org.openapitools.client");
        }
        if (!additionalProperties.containsKey(CodegenConstants.API_PACKAGE)) {
            additionalProperties.put(CodegenConstants.API_PACKAGE, additionalProperties.get(CodegenConstants.PACKAGE_NAME) + ".api");
        }
        if (!additionalProperties.containsKey(CodegenConstants.MODEL_PACKAGE)) {
            additionalProperties.put(CodegenConstants.MODEL_PACKAGE, additionalProperties.get(CodegenConstants.PACKAGE_NAME) + ".model");
        }
        super.processOpts();
    }

    @Override
    public void setTemplatingEngine(TemplatingEngineAdapter templatingEngine) {
    }

    @Override
    public ModelsMap postProcessModels(ModelsMap objs) {
        var modelsMap = super.postProcessModels(objs);
        for (ModelMap model : modelsMap.getModels()) {
            if (model.getModel().isEnum) {
                objs.getImports().add(Map.of("import", "lombok.Getter"));
                objs.getImports().add(Map.of("import", "lombok.ToString"));
                objs.getImports().add(Map.of("import", "lombok.RequiredArgsConstructor"));
            } else if (!model.getModel().isEnum && (model.getModel().oneOf != null || model.getModel().oneOf.isEmpty())) {
                objs.getImports().add(Map.of("import", "lombok.Data"));
                for (CodegenProperty property : model.getModel().getVars()) {
                    if (property.isEnum) {
                        objs.getImports().add(Map.of("import", "lombok.Getter"));
                        objs.getImports().add(Map.of("import", "lombok.ToString"));
                        objs.getImports().add(Map.of("import", "lombok.RequiredArgsConstructor"));
                    }
                }

            }
        }

        return modelsMap;
    }

    @Override
    public String getName() {
        return "java-lombok";
    }
}
