package io.github.jhannes.openapi.javalombok;

import org.openapitools.codegen.CodegenConstants;
import org.openapitools.codegen.api.TemplatingEngineAdapter;
import org.openapitools.codegen.languages.AbstractJavaCodegen;
import org.openapitools.codegen.templating.HandlebarsEngineAdapter;

public class JavaCodegen extends AbstractJavaCodegen {

    public JavaCodegen() {
        templateDir = "JavaLombok";
        super.setTemplatingEngine(new HandlebarsEngineAdapter());

        apiDocTemplateFiles.clear();
        apiTestTemplateFiles.clear();
        modelTestTemplateFiles.clear();
        modelDocTemplateFiles.clear();
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
    public String getName() {
        return "java-lombok";
    }
}
