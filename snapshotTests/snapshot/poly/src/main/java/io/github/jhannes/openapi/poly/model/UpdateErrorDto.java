package io.github.jhannes.openapi.poly.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

public sealed interface UpdateErrorDto permits DuplicateIdentifierErrorDto, GeneralErrorDto, IllegalEmailAddressErrorDto, NotFoundErrorDto {

    String getCode();

    static Class<? extends UpdateErrorDto> getType(String code) {
        return switch (code) {
            case "duplicate_identifier" -> DuplicateIdentifierErrorDto.class;
            case "general_error" -> GeneralErrorDto.class;
            case "illegal_address" -> IllegalEmailAddressErrorDto.class;
            case "network_error" -> GeneralErrorDto.class;
            case "not_found" -> NotFoundErrorDto.class;
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

    static NotFoundErrorDto createNot_found() {
        return new NotFoundErrorDto().setCode("not_found");
    }

    boolean isEmpty();
    List<String> missingRequiredFields(String prefix);
}