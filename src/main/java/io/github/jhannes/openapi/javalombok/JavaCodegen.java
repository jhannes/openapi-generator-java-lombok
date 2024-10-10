package io.github.jhannes.openapi.javalombok;

import io.swagger.v3.oas.models.media.Schema;
import org.apache.commons.lang3.StringUtils;
import org.openapitools.codegen.CodegenConstants;
import org.openapitools.codegen.CodegenDiscriminator;
import org.openapitools.codegen.CodegenModel;
import org.openapitools.codegen.CodegenProperty;
import org.openapitools.codegen.IJsonSchemaValidationProperties;
import org.openapitools.codegen.SupportingFile;
import org.openapitools.codegen.api.TemplatingEngineAdapter;
import org.openapitools.codegen.languages.AbstractJavaCodegen;
import org.openapitools.codegen.model.ModelMap;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.utils.ModelUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class JavaCodegen extends AbstractJavaCodegen {

    private final Set<String> mixinInterfaces = new HashSet<>();

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
    public String getName() {
        return "java-lombok";
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
        cm.interfaceModels = new ArrayList<>();
        cm.imports.remove("ApiModel");
        cm.imports.remove("ApiModelProperty");

        cm.allVars.removeIf(v -> cm.vars.stream().anyMatch(vv -> vv.name.equals(v.name)));
        cm.allVars.addAll(cm.vars);

        return cm;
    }

    @Override
    public String toSetter(String name) {
        return "set" + capitalizeFirst(name);
    }

    @Override
    public String toGetter(String name) {
        return "get" + capitalizeFirst(name);
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

        supportingFiles.add(new SupportingFile("lombok.config", sourceFolder + File.separator + modelPackage().replace('.', File.separatorChar), "lombok.config"));
        if (additionalProperties.get(CodegenConstants.GENERATE_MODEL_TESTS) == Boolean.TRUE) {
            supportingFiles.add(new SupportingFile("sampleData.handlebars", sourceFolder + File.separator + modelPackage().replace('.', File.separatorChar), "SampleData.java"));
            supportingFiles.add(new SupportingFile("sampleModelData.handlebars", sourceFolder + File.separator + modelPackage().replace('.', File.separatorChar), "SampleModelData.java"));
        }
    }

    @Override
    public void setTemplatingEngine(TemplatingEngineAdapter templatingEngine) {
    }

    @Override
    public void postProcessModelProperty(CodegenModel model, CodegenProperty property) {
        super.postProcessModelProperty(model, property);
        model.imports.remove("Arrays");
    }

    @Override
    public String toModelName(String name) {
        return mixinInterfaces.contains(name) ? name : super.toModelName(name);
    }

    @Override
    public Map<String, ModelsMap> postProcessAllModels(Map<String, ModelsMap> objs) {
        Map<String, ModelsMap> result = super.postProcessAllModels(objs);
        processAllOfTypes(result);
        processOneOfInterfaces(result);
        setupDerivedVariables(result);
        return result;
    }

    private void setupDerivedVariables(Map<String, ModelsMap> result) {
        List<CodegenModel> allCodegenModels = getCodegenModels(result.values());
        for (CodegenModel model : allCodegenModels) {
            Set<CodegenModel> children = new TreeSet<>(Comparator.comparing(CodegenModel::getClassname));
            allCodegenModels.stream().filter(c -> c.parentModel == model).forEach(children::add);
            allCodegenModels.stream().filter(c -> c.interfaceModels.contains(model)).forEach(children::add);
            model.children = new ArrayList<>(children);
        }

        Map<String, CodegenModel> allModels = getAllModels(result);
        for (ModelsMap modelsMap : result.values()) {
            for (ModelMap modelMap : modelsMap.getModels()) {
                CodegenModel model = modelMap.getModel();
                model.parent = model.additionalPropertiesType != null
                        ? model.parent // TODO: set parentModel as well?
                        : model.parentModel != null ? model.parentModel.classname : null;
                model.interfaces = model.interfaceModels.stream()
                        .map(CodegenModel::getClassname)
                        .collect(Collectors.toList());

                for (CodegenProperty var : model.getAllVars()) {
                    if (var.isModel && var.required && allModels.get(var.dataType).oneOf.isEmpty()) {
                        var.defaultValue = "new " + var.dataType + "()";
                    }
                    if (var.get_enum() != null && var.get_enum().size() == 1) {
                        var.defaultValue = "\"" + var.get_enum().getFirst() + "\"";
                        var.dataType = "\"" + var.get_enum().getFirst() + "\"";
                        var.datatypeWithEnum = "String";
                        var.defaultValueWithParam = var.defaultValue;
                        var.isEnum = var.isInnerEnum = false;
                        var.allowableValues = null;
                        var.isInherited = false;
                    }
                }
                model.vars = model.getAllVars().stream().filter(v -> !v.isInherited).toList();
                model.parentVars = model.getAllVars().stream().filter(v -> v.isInherited).toList();
                model.requiredVars = model.getVars().stream().filter(v -> v.required).toList();
                model.hasRequired = !model.requiredVars.isEmpty();
                model.hasMoreModels = model.vars.stream().anyMatch(v -> v.isModel);
                model.optionalVars = model.getVars().stream().filter(v -> !v.required).toList();
                model.hasOptional = !model.optionalVars.isEmpty();
                model.hasEnums = model.getVars().stream().anyMatch(v -> v.isEnum);
                model.hasEnums = model.getVars().stream().anyMatch(v -> v.isEnum);
                boolean hasInnerEnum = model.getVars().stream().anyMatch(v -> v.isInnerEnum && v.isEnum);

                if (!model.isEnum) {
                    addImport(modelsMap, "java.util.List");
                }
                if (model.oneOf.isEmpty() && !model.classname.endsWith("Interface") && !model.isEnum) {
                    addImport(modelsMap, "lombok.Data");
                    if (model.parent != null) {
                        addImport(modelsMap, "lombok.EqualsAndHashCode");
                    }
                }
                if (model.isEnum || hasInnerEnum) {
                    addImport(modelsMap, "lombok.Getter");
                    addImport(modelsMap, "lombok.RequiredArgsConstructor");
                }
                if (model.hasRequired || model.hasMoreModels) {
                    addImport(modelsMap, "java.util.ArrayList");
                }
                if (model.hasOptional) {
                    addImport(modelsMap, "java.util.Objects");
                }
                modelsMap.getImports().sort(Comparator.comparing(s -> s.get("import")));
            }
        }
    }

    private static void addImport(ModelsMap modelsMap, String importedClass) {
        if (!modelsMap.getImports().contains(Map.of("import", importedClass))) {
            modelsMap.getImports().add(Map.of("import", importedClass));
        }
    }

    private void processAllOfTypes(Map<String, ModelsMap> result) {
        Map<String, CodegenModel> multiplyInheritedTypes = new HashMap<>();
        Map<String, CodegenModel> allModels = getAllModels(result);
        for (Map.Entry<String, CodegenModel> codegenEntry : allModels.entrySet()) {
            CodegenModel codegenModel = codegenEntry.getValue();
            if (codegenModel.allOf.size() > 1) {
                for (String implementedInterfaceName : codegenModel.allOf) {
                    CodegenModel implementedInterface = allModels.get(implementedInterfaceName);
                    codegenModel.interfaceModels.add(multiplyInheritedTypes
                            .computeIfAbsent(implementedInterface.name, i -> createMixin(implementedInterface)));
                    CodegenModel parentInterface = implementedInterface.parentModel;
                    while (parentInterface != null) {
                        if (!multiplyInheritedTypes.containsKey(parentInterface.name)) {
                            multiplyInheritedTypes.put(parentInterface.name, createMixin(parentInterface));
                        }
                        //codegenModel.interfaceModels.add(multiplyInheritedTypes.get(parentInterface.name));
                        parentInterface = parentInterface.parentModel;
                    }
                }
                for (CodegenProperty var : codegenModel.allVars) {
                    for (CodegenModel interfaceModel : codegenModel.interfaceModels) {
                        if (interfaceModel.allVars.stream().anyMatch(v -> v.name.equals(var.name))) {
                            var.isNew = true;
                        }
                    }
                }
            } else if (!codegenModel.allOf.isEmpty()) {
                codegenModel.parentModel = allModels.get(codegenModel.allOf.iterator().next());
                for (CodegenProperty var : codegenModel.allVars) {
                    if (codegenModel.parentModel.allVars.stream().anyMatch(v -> v.name.equals(var.name))) {
                        var.isInherited = true; // TODO: remove?
                        var.isNew = true;
                    }
                }
            }
        }
        for (CodegenModel interfaceModel : multiplyInheritedTypes.values()) {
            ModelsMap modelsMap = result.get(interfaceModel.name);

            CodegenModel dtoModel = modelsMap.getModels().get(0).getModel();
            dtoModel.interfaceModels = List.of(interfaceModel);
            dtoModel.allOf = Set.of();
            if (dtoModel.parentModel != null) {
                interfaceModel.parentModel = multiplyInheritedTypes.get(dtoModel.parentModel.name);
                interfaceModel.interfaceModels.add(interfaceModel.parentModel);
            }

            ModelMap modelMap = new ModelMap();
            modelMap.setModel(interfaceModel);
            ModelsMap models = new ModelsMap();
            models.putAll(modelsMap);
            models.setModels(List.of(modelMap));
            result.put(interfaceModel.classname, models);

            mixinInterfaces.add(interfaceModel.classname);

            for (CodegenModel codegenModel : allModels.values()) {
                if (codegenModel.interfaceModels.contains(interfaceModel)) {
                    for (CodegenProperty property : codegenModel.allVars) {
                        if (property.isEnum) {
                            property.isEnum = false;
                            property.dataType = property.datatypeWithEnum;
                        }
                    }
                }
            }
        }
    }

    private static CodegenModel createMixin(CodegenModel dtoModel) {
        CodegenModel interfaceModel = new CodegenModel() {
            public boolean isMixin = true;

            public Collection<CodegenModel> getDescendants() {
                Map<String, CodegenModel> result = new TreeMap<>();
                putDescendants(this, result);
                return result.values();
            }

            private void putDescendants(CodegenModel codegenModel, Map<String, CodegenModel> descendants) {
                for (CodegenModel child : codegenModel.children) {
                    if (descendants.containsKey(child.name)) {
                        // prefer interface to implementation
                        if (descendants.get(child.name).interfaceModels.contains(child)) {
                            descendants.put(child.name, child);
                        }
                    } else {
                        descendants.put(child.name, child);
                    }
                    putDescendants(child, descendants);
                }
            }
        };
        interfaceModel.name = dtoModel.name;
        interfaceModel.interfaceModels = new ArrayList<>();
        interfaceModel.classname = dtoModel.name + "Interface";
        for (CodegenProperty property : dtoModel.allVars) {
            CodegenProperty clone = property.clone();
            interfaceModel.allVars.add(clone);
            property.isNew = true;
        }
        return interfaceModel;
    }

    private static List<CodegenModel> getCodegenModels(Collection<ModelsMap> modelMaps) {
        return modelMaps.stream()
                .flatMap(m -> m.getModels().stream().map(ModelMap::getModel))
                .toList();
    }

    private void processOneOfInterfaces(Map<String, ModelsMap> objs) {
        Map<String, List<CodegenModel>> interfacesOfSubtypes = new HashMap<>();
        Map<String, CodegenModel> allModels = getAllModels(objs);
        for (CodegenModel codegenModel : allModels.values()) {
            if (!codegenModel.oneOf.isEmpty()) {
                postProcessOneOf(codegenModel, interfacesOfSubtypes, allModels);
            }
        }

        for (String implementationTypeName : interfacesOfSubtypes.keySet()) {
            CodegenModel codegenModel = allModels.get(implementationTypeName);
            codegenModel.interfaceModels = interfacesOfSubtypes.get(codegenModel.classname);
        }
    }

    public void postProcessOneOf(CodegenModel codegenModel, Map<String, List<CodegenModel>> interfacesOfSubtypes, Map<String, CodegenModel> allModels) {
        Set<CodegenDiscriminator.MappedModel> mappedModels = new HashSet<>();
        HashMap<String, String> mapping = new HashMap<>();
        CodegenDiscriminator discriminator = codegenModel.discriminator;
        if (discriminator != null) {
            discriminator.setPropertyName(discriminator.getPropertyBaseName());
            discriminator.setPropertyGetter(toGetter(discriminator.getPropertyBaseName()));
        }
        for (String className : codegenModel.oneOf) {
            CodegenModel subModel = allModels.get(className);
            if (subModel.oneOf.isEmpty()) {
                mappedModels.add(new CodegenDiscriminator.MappedModel(subModel.name, className));
                mapping.put(subModel.name, className);
            } else if (
                    discriminator != null
                    && subModel.discriminator != null
                    && subModel.discriminator.getPropertyName().equals(discriminator.getPropertyName())
            ) {
                if (subModel.discriminator.getMapping() == null) {
                    postProcessOneOf(subModel, interfacesOfSubtypes, allModels);
                }
                mappedModels.addAll(subModel.discriminator.getMappedModels());
                mapping.putAll(subModel.discriminator.getMapping());
            } else if (discriminator != null && subModel.discriminator != null) {
                //not matching discriminators, cannot be matched from spec
                continue;
            }
            List<CodegenModel> subtypeInterfaces = interfacesOfSubtypes.computeIfAbsent(className, k -> new ArrayList<>());
            if (!subtypeInterfaces.contains(codegenModel)) {
                subtypeInterfaces.add(codegenModel);
            }
            if (codegenModel.getDiscriminatorName() != null && subModel.allVars.stream().noneMatch(v -> v.baseName.equals(codegenModel.getDiscriminatorName()))) {
                CodegenProperty property = new CodegenProperty();
                property.name = property.baseName = codegenModel.getDiscriminatorName();
                property.getter = toGetter(property.name);
                property.setter = toSetter(property.name);
                property.isString = true;
                property.dataType = property.datatypeWithEnum = "String";
                property.required = true;
                property.defaultValue = "\"" + subModel.name + "\"";
                property.isInherited = false;
                property.isNew = true;
                property.isDiscriminator = true;
                subModel.allVars.addFirst(property);
            }
        }
        codegenModel.allVars.removeIf(var -> codegenModel.interfaceModels.stream().anyMatch(model -> varNotInImplementation(var, model)));
        if (discriminator != null && discriminator.getMapping() == null) {
            discriminator.setMapping(mapping);
            discriminator.setMappedModels(mappedModels);
        }
        if (discriminator != null) {
            codegenModel.allVars.removeIf(v -> v.name.equals(discriminator.getPropertyName()));
        }
    }

    private static String capitalizeFirst(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
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
    public String toEnumVarName(String value, String datatype) {
        if (enumNameMapping.containsKey(value)) {
            return enumNameMapping.get(value);
        }

        if (value.isEmpty()) {
            return "EMPTY";
        }

        // for symbol, e.g. $, #
        if (getSymbolName(value) != null) {
            return getSymbolName(value).toUpperCase(Locale.ROOT);
        }

        if (" ".equals(value)) {
            return "SPACE";
        }

        // number
        if ("Integer".equals(datatype) || "Long".equals(datatype) ||
            "Float".equals(datatype) || "Double".equals(datatype) || "BigDecimal".equals(datatype)) {
            String varName = "NUMBER_" + value;
            varName = varName.replaceAll("-", "MINUS_");
            varName = varName.replaceAll("\\+", "PLUS_");
            varName = varName.replaceAll("\\.", "_DOT_");
            return varName;
        }

        // string
        String var = value.replaceAll("\\W+", "_");
        if (var.matches("\\d.*")) {
            var = "_" + var;
        }
        return reservedWords.contains(var) ? escapeReservedWord(var) : var;
    }
}
