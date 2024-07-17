package io.github.jhannes.openapi.poly.model;

import lombok.*;

public sealed interface UpdateErrorDto permits DuplicateIdentifierErrorDto, GeneralErrorDto, IllegalEmailAddressErrorDto, NotFoundErrorDto {

    static Class<? extends UpdateErrorDto> getType(String code) {
        return switch (code) {
            case "duplicateIdentifier" -> DuplicateIdentifierErrorDto.class;
            case "generalError" -> GeneralErrorDto.class;
            case "illegalAddress" -> IllegalEmailAddressErrorDto.class;
            case "networkError" -> GeneralErrorDto.class;
            case "notFound" -> NotFoundErrorDto.class;
            default -> throw new IllegalArgumentException("Illegal code " + code);
        };
    }
}