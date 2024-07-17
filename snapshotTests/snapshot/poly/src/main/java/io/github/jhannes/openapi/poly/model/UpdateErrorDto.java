package io.github.jhannes.openapi.poly.model;

import lombok.*;

public sealed interface UpdateErrorDto permits DuplicateIdentifierErrorDto, GeneralErrorDto, IllegalEmailAddressErrorDto, NotFoundErrorDto {

    String getCode();

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

    static DuplicateIdentifierErrorDto createduplicateIdentifier() {
        return new DuplicateIdentifierErrorDto().setCode("duplicateIdentifier");
    }

    static GeneralErrorDto creategeneralError() {
        return new GeneralErrorDto().setCode("generalError");
    }

    static IllegalEmailAddressErrorDto createillegalAddress() {
        return new IllegalEmailAddressErrorDto().setCode("illegalAddress");
    }

    static GeneralErrorDto createnetworkError() {
        return new GeneralErrorDto().setCode("networkError");
    }

    static NotFoundErrorDto createnotFound() {
        return new NotFoundErrorDto().setCode("notFound");
    }
}