package io.github.jhannes.openapi.javalombok;

import org.openapitools.codegen.languages.AbstractJavaCodegen;

public class JavaCodegen extends AbstractJavaCodegen {

    public JavaCodegen() {
        System.out.println("test");
    }

    @Override
    public String getName() {
        return "java-lombok";
    }
}
