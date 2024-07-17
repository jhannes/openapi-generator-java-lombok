package io.github.jhannes.openapi.poly.model;

import lombok.*;

@Data
public final class NotFoundErrorDto implements UpdateErrorDto {

    private String code;
    private String identifierValue = null;
    private String entityType;

}