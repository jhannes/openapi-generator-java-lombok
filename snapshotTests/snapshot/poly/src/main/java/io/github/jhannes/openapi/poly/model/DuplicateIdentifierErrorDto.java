package io.github.jhannes.openapi.poly.model;

import lombok.*;

@Data
public final class DuplicateIdentifierErrorDto implements CreationErrorDto, UpdateErrorDto {

    private String code;
    private String identifierValue = null;
    private String entityType;

}