package io.github.jhannes.openapi.poly.model;

import java.util.List;

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

    CreationErrorDto putAll(CreationErrorDto o);
    CreationErrorDto removeWhereEqual(CreationErrorDto o);
    boolean hasNoOptionalProperties();
    List<String> missingRequiredFields(String prefix);

    default void copyToDuplicateIdentifierError(DuplicateIdentifierErrorDto o) {
    }
    default void copyToGeneralError(GeneralErrorDto o) {
    }
    default void copyToIllegalEmailAddressError(IllegalEmailAddressErrorDto o) {
    }
    default void removeWhereEqualFromDuplicateIdentifierError(DuplicateIdentifierErrorDto o) {
    }
    default void removeWhereEqualFromGeneralError(GeneralErrorDto o) {
    }
    default void removeWhereEqualFromIllegalEmailAddressError(IllegalEmailAddressErrorDto o) {
    }
}