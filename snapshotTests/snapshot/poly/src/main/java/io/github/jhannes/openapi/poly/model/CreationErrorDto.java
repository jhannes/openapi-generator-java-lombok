package io.github.jhannes.openapi.poly.model;

import lombok.*;

public sealed interface CreationErrorDto permits DuplicateIdentifierErrorDto, GeneralErrorDto, IllegalEmailAddressErrorDto {

    static Class<? extends CreationErrorDto> getType(String code) {
        return switch (code) {
            case "duplicateIdentifier" -> DuplicateIdentifierErrorDto.class;
            case "generalError" -> GeneralErrorDto.class;
            case "illegalAddress" -> IllegalEmailAddressErrorDto.class;
            case "networkError" -> GeneralErrorDto.class;
            default -> throw new IllegalArgumentException("Illegal code " + code);
        };
    }
}