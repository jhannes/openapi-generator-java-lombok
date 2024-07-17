package io.github.jhannes.openapi.javalombok;

import io.swagger.v3.oas.models.media.Schema;
import org.apache.commons.lang3.StringUtils;
import org.openapitools.codegen.CodegenConstants;
import org.openapitools.codegen.CodegenDiscriminator;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;
import org.openapitools.codegen.IJsonSchemaValidationProperties;
import org.openapitools.codegen.api.TemplatingEngineAdapter;
import org.openapitools.codegen.languages.AbstractJavaCodegen;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.utils.ModelUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class JavaCodegen extends AbstractJavaCodegen {

    public JavaCodegen() {
        openApiNullable = false;
        templateDir = "JavaLombok";
        super.setTemplatingEngine(new PatchedHandlebarsEngineAdapter());

        apiDocTemplateFiles.clear();
        apiTestTemplateFiles.clear();
        modelTestTemplateFiles.clear();
        modelDocTemplateFiles.clear();

        importMapping.put("EqualsAndHashCode", "lombok.EqualsAndHashCode");
        importMapping.put("Data", "lombok.Data");
        importMapping.put("ToString", "lombok.ToString");
        importMapping.put("Getter", "lombok.Getter");
        importMapping.put("RequiredArgsConstructor", "lombok.RequiredArgsConstructor");
    }

    @Override
    protected void addImports(CodegenModel m, IJsonSchemaValidationProperties type) {
        if (!type.getIsModel() && !type.getIsEnum() && (type.getItems() == null || type.getItems().getIsEnum() || type.getItems().isContainer)) {
            super.addImports(m, type);
        }
    }

    @Override
    protected void addImport(Schema composed, Schema childSchema, CodegenModel model, String modelName) {
    }

    @Override
    protected void updateModelForComposedSchema(CodegenModel m, Schema schema, Map<String, Schema> allDefinitions) {
        //super.updateModelForComposedSchema(m, schema, allDefinitions);
        if (schema.getAllOf() != null) {
            m.allOf = new TreeSet<>();
            for (Schema<?> refSchema : ModelUtils.getInterfaces(schema)) {
                List<String> required = new ArrayList<>();
                Map<String, Schema> properties = new LinkedHashMap<>();
                addProperties(properties, required, refSchema, new HashSet<>());
                if (StringUtils.isBlank(refSchema.get$ref())) {
                    addVars(m, unaliasPropertySchema(properties), required, unaliasPropertySchema(properties), required);
                } else {
                    String ref = ModelUtils.getSimpleRef(refSchema.get$ref());
                    m.allOf.add(toModelName(ref));
                    addVars(m, Map.of(), List.of(), unaliasPropertySchema(properties), required);
                }
            }
            if (m.allOf.size() == 1) {
                m.parent = m.allOf.iterator().next();
            }
        }
        if (schema.getOneOf() != null) {
            m.oneOf = new TreeSet<>();
            for (Schema<?> refSchema : ModelUtils.getInterfaces(schema)) {
                String ref = ModelUtils.getSimpleRef(refSchema.get$ref());
                m.oneOf.add(toModelName(ref));
            }
        }
    }

    @Override
    public CodegenModel fromModel(String name, Schema model) {
        CodegenModel cm = super.fromModel(name, model);
        cm.interfaces = null;
        cm.interfaceModels = new ArrayList<>();

        for (CodegenProperty property : cm.getVars()) {
            if (property.get_enum() != null && property.get_enum().size() == 1) {
                property.defaultValue = "\"" + property.get_enum().getFirst() + "\"";
                property.dataType = "\"" + property.get_enum().getFirst() + "\"";
                property.datatypeWithEnum = "String";
                property.defaultValueWithParam = property.defaultValue;
                property.isEnum = property.isInnerEnum = false;
                property.allowableValues = null;
            }
        }

        cm.imports.remove("ApiModel");
        cm.imports.remove("ApiModelProperty");

        if (cm.isEnum) {
            //cm.imports.add("Getter");
            //cm.imports.add("ToString");
            //cm.imports.add("RequiredArgsConstructor");
        } else if ((cm.oneOf == null || cm.oneOf.isEmpty())) {
            //cm.imports.add("Data");
            for (CodegenProperty property : cm.getVars()) {
                if (property.isInnerEnum) {
                    //cm.imports.add("Getter");
                    //cm.imports.add("ToString");
                    //cm.imports.add("RequiredArgsConstructor");
                }
            }
        }

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
        return modelsMap;
    }

    @Override
    public void postProcessModelProperty(CodegenModel model, CodegenProperty property) {
        super.postProcessModelProperty(model, property);
        model.imports.remove("Arrays");
    }

    @Override
    public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
        Map<String, ModelsMap> result = super.postProcessAllModels(objs);
        for (CodegenModel codegenModel : getAllModels(result).values()) {
            codegenModel.children = null;
        }
        processOneOfInterfaces(result);
        processSealedClassed(result);
        return result;
    }

    private void processSealedClassed(Map<String, ModelsMap> objs) {
        Map<String, List<String>> subclassesOfType = new HashMap<>();
        for (CodegenModel codegenModel : getAllModels(objs).values()) {
            if (codegenModel.parentModel != null) {
                subclassesOfType.computeIfAbsent(codegenModel.parentModel.classname, ignored -> new ArrayList<>())
                        .add(codegenModel.classname);
                if (codegenModel.parentModel.children == null) {
                    codegenModel.parentModel.children = new ArrayList<>();
                }
                codegenModel.parentModel.children.add(codegenModel);
            }
        }
    }

    private void processOneOfInterfaces(Map<String, ModelsMap> objs) {
        Map<String, List<CodegenModel>> interfacesOfSubtypes = new HashMap<>();
        Map<String, CodegenModel> allModels = getAllModels(objs);
        for (CodegenModel codegenModel : allModels.values()) {
            if (!codegenModel.oneOf.isEmpty()) {
                postProcessOneOf(codegenModel, interfacesOfSubtypes, allModels);
            }
        }
        for (Map.Entry<String, CodegenModel> modelEntry : allModels.entrySet()) {
            modelEntry.getValue().interfaceModels = interfacesOfSubtypes.get(modelEntry.getKey());
            if (modelEntry.getValue().interfaceModels != null) {
                modelEntry.getValue().interfaces = modelEntry.getValue().interfaceModels.stream()
                        .map(CodegenModel::getClassname)
                        .collect(Collectors.toList());
            } else if (!modelEntry.getValue().oneOf.isEmpty()) {
                modelEntry.getValue().interfaces = null;
            }
        }
    }

    public void postProcessOneOf(CodegenModel codegenModel, Map<String, List<CodegenModel>> interfacesOfSubtypes, Map<String, CodegenModel> allModels) {
        Set<CodegenDiscriminator.MappedModel> mappedModels = new HashSet<>();
        HashMap<String, String> mapping = new HashMap<>();
        for (String className : codegenModel.oneOf) {
            CodegenModel subModel = allModels.get(className);
            if (subModel.oneOf.isEmpty()) {
                mappedModels.add(new CodegenDiscriminator.MappedModel(subModel.name, className));
                mapping.put(subModel.name, className);
            } else if (
                    codegenModel.discriminator != null
                    && subModel.discriminator != null
                    && subModel.discriminator.getPropertyName().equals(codegenModel.discriminator.getPropertyName())
            ) {
                if (subModel.discriminator.getMapping() == null) {
                    postProcessOneOf(subModel, interfacesOfSubtypes, allModels);
                }
                mappedModels.addAll(subModel.discriminator.getMappedModels());
                mapping.putAll(subModel.discriminator.getMapping());
            } else if (codegenModel.discriminator != null && subModel.discriminator != null) {
                //not matching discriminators, cannot be matched from spec
                continue;
            }
            if (codegenModel.children == null) {
                codegenModel.children = new ArrayList<>();
            }
            codegenModel.children.add(subModel);
            List<CodegenModel> subtypeInterfaces = interfacesOfSubtypes.computeIfAbsent(className, k -> new ArrayList<>());
            if (!subtypeInterfaces.contains(codegenModel)) {
                subtypeInterfaces.add(codegenModel);
            }
        }
        codegenModel.allVars.removeIf(var -> codegenModel.interfaceModels.stream().anyMatch(model -> varNotInImplementation(var, model)));
        if (codegenModel.discriminator != null && codegenModel.discriminator.getMapping() == null) {
            codegenModel.discriminator.setMapping(mapping);
            codegenModel.discriminator.setMappedModels(mappedModels);
        }
        if (codegenModel.discriminator != null) {
            codegenModel.allVars.removeIf(v -> v.name.equals(codegenModel.discriminator.getPropertyName()));
        }
    }

    private static boolean varNotInImplementation(CodegenProperty var, CodegenModel model) {
        if (!model.oneOf.isEmpty()) {
            for (CodegenModel subtype : model.interfaceModels) {
                if (varNotInImplementation(var, subtype)) {
                    return true;
                }
            }
        }
        return model.allVars.stream()
                .noneMatch(memberVar -> memberVar.name.equals(var.name) && memberVar.datatypeWithEnum.equals(var.datatypeWithEnum));
    }

    @Override
    public String getName() {
        return "java-lombok";
    }
}
