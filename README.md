[![Java CI with Maven](https://github.com/jhannes/openapi-generator-java-lombok/actions/workflows/maven.yml/badge.svg)](https://github.com/jhannes/openapi-generator-java-lombok/actions/workflows/maven.yml)
[![Apache 2.0 License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# OpenAPI Generator for Java with support for nested allOf-types and multiple inheritance with oneOf

This generates creates Java classes using [Project Lombok](https://projectlombok.org/) for implementing and using OpenAPI APIs in Java. This provides concise generated code. The generator supports many of the more advanced features of the OpenAPI spec

## Features

* Generates concise POJOs using [Project Lombok](https://projectlombok.org/)
* Generates POJOs without dependencies on JSON serialization frameworks
* Models are generated with convenient methods for checking missing required fields and read-only fields with values and to copy between objects
* Implements type polymorphism with `oneOf`-types, even supporting multiple inheritance for classes that are included in multiple `oneOf`-types
* Implements inheritance with `allOf`-types, including multiple levels of inheritance
* TODO: Generates client code using HttpURLConnection for HTTP and JSONB for JSON deserialization
* Supports optional, repeated and binary request parameters
* TODO: Generates SampleData which can provide randomized model data, accepting a seed to generate the same data every time


## What's OpenAPI

The goal of OpenAPI is to define a standard, language-agnostic interface to REST APIs which allows both humans and computers to discover and understand the capabilities of the service without access to source code, documentation, or through network traffic inspection.
When properly described with OpenAPI, a consumer can understand and interact with the remote service with a minimal amount of implementation logic.
Similar to what interfaces have done for lower-level programming, OpenAPI removes the guesswork in calling the service.

Check out [OpenAPI-Spec](https://github.com/OAI/OpenAPI-Specification) for additional information about the OpenAPI project, including additional libraries with support for other languages and more.

## How do I use this?

Add to your `pom.xml`:

```xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.openapitools</groupId>
                <artifactId>openapi-generator-maven-plugin</artifactId>
                <version>7.14.0</version>
                <executions>
                    <execution>
                        <id>openapi-java</id>
                        <goals>
                            <goal>generate</goal>
                        </goals>
                        <configuration>
                            <generatorName>java-lombok</generatorName>
                            <!-- REPLACE WITH YOUR OWN SPECIFICATION -->
                            <inputSpec>${project.basedir}/src/main/openapi-spec/openapi.yaml</inputSpec>
                            <!-- REPLACE WITH YOUR OWN PACKAGE NAME -->
                            <packageName>io.example.openapi</packageName>
                            <modelNameSuffix>Dto</modelNameSuffix>
                            <!-- IF YOU WANT TO GENERATE FROM MORE THAN ONE SPEC, YOU PROBABLY WANT SEVERAL OUTPUTS -->
                            <output>target/generated-sources/openapi-java</output>
                        </configuration>
                    </execution>
                </executions>
                <dependencies>
                    <dependency>
                        <groupId>io.github.jhannes.openapi</groupId>
                        <artifactId>openapi-generator-java-lombok</artifactId>
                        <version>0.4.1</version>
                    </dependency>
                </dependencies>
            </plugin>
        </plugins>
    </build>

```

## Sample output

### [Petstore model](https://github.com/jhannes/openapi-generator-java-lombok/tree/main/snapshotTests/snapshot/petstore/src/main/java/io/github/jhannes/openapi/petstore/model)

### [Polymorphism](https://github.com/jhannes/openapi-generator-java-lombok/blob/main/snapshotTests/input/poly.yaml)

```yaml
components:
  schemas:
    CreationError:
      oneOf:
        - $ref: '#/components/schemas/GeneralError'
        - $ref: '#/components/schemas/DuplicateIdentifierError'
        - $ref: '#/components/schemas/IllegalEmailAddressError'
      discriminator:
        propertyName: code
        mapping:
          general_error: '#/components/schemas/GeneralError'
          network_error: '#/components/schemas/GeneralError'
          duplicate_identifier: '#/components/schemas/DuplicateIdentifierError'
          illegal_address: '#/components/schemas/IllegalEmailAddressError'
    UpdateError:
      oneOf:
        - $ref: '#/components/schemas/GeneralError'
        - $ref: '#/components/schemas/NotFoundError'
        - $ref: '#/components/schemas/DuplicateIdentifierError'
        - $ref: '#/components/schemas/IllegalEmailAddressError'
      discriminator:
        propertyName: code
        mapping:
          general_error: '#/components/schemas/GeneralError'
          network_error: '#/components/schemas/GeneralError'
          not_found: '#/components/schemas/NotFoundError'
          duplicate_identifier: '#/components/schemas/DuplicateIdentifierError'
          illegal_address: '#/components/schemas/IllegalEmailAddressError'
    GeneralError:
      properties:
        code:
          type: string
        description:
          type: string
      required:
        - code
        - description
```

#### [Generated oneOf-interface](https://github.com/jhannes/openapi-generator-java-lombok/blob/main/snapshotTests/snapshot/poly/src/main/java/io/github/jhannes/openapi/poly/model/CreationErrorDto.java)

```java
public sealed interface CreationErrorDto permits DuplicateIdentifierErrorDto, GeneralErrorDto, IllegalEmailAddressErrorDto {

    String getCode();

    static Class<? extends CreationErrorDto> getType(String code) {
        return switch (code) {
            case "duplicate_identifier" -> DuplicateIdentifierErrorDto.class;
            case "general_error" -> GeneralErrorDto.class;
            case "illegal_address" -> IllegalEmailAddressErrorDto.class;
            case "network_error" -> GeneralErrorDto.class;
            default -> throw new IllegalArgumentException("Illegal code " + code);
        };
    }

    static DuplicateIdentifierErrorDto createDuplicate_identifier() {
        return new DuplicateIdentifierErrorDto().setCode("duplicate_identifier");
    }

    static GeneralErrorDto createGeneral_error() {
        return new GeneralErrorDto().setCode("general_error");
    }

    static IllegalEmailAddressErrorDto createIllegal_address() {
        return new IllegalEmailAddressErrorDto().setCode("illegal_address");
    }

    static GeneralErrorDto createNetwork_error() {
        return new GeneralErrorDto().setCode("network_error");
    }
}
```

### [Generated Java implementation](https://github.com/jhannes/openapi-generator-java-lombok/blob/main/snapshotTests/snapshot/poly/src/main/java/io/github/jhannes/openapi/poly/model/GeneralErrorDto.java)

```java
package io.github.jhannes.openapi.poly.model;

import lombok.*;

@Data
public final class GeneralErrorDto implements CreationErrorDto, UpdateErrorDto {

    private String code;
    private String description;

}
```

## Contribution

Pull requests are welcome. In order to safely support changes, the project comes with a large set of OpenAPI specs for which snapshot tests are generated. If a change produces different output for one of the included specs the tests fail until the snapshots are updated.

For an effective development process, see [FocusedExampleTest](https://github.com/jhannes/openapi-generator-java-lombok/blob/main/src/test/java/io/github/jhannes/openapi/javalombok/FocusedExampleTest.java)
