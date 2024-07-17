package io.github.jhannes.openapi.poly.model;

import lombok.*;

@Data
public final class GeneralErrorDto implements CreationErrorDto, UpdateErrorDto {

    private String code;
    private String description;

}