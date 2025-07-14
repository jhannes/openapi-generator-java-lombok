package io.github.jhannes.openapi.poly.model;

import java.util.List;

public sealed interface AnyPartyDto permits OrganizationDto, PersonDto {

    String getType();

    static Class<? extends AnyPartyDto> getType(String type) {
        return switch (type) {
            case "organization" -> OrganizationDto.class;
            case "person" -> PersonDto.class;
            default -> throw new IllegalArgumentException("Illegal type " + type);
        };
    }

    static OrganizationDto createOrganization() {
        return new OrganizationDto().setType("organization");
    }

    static PersonDto createPerson() {
        return new PersonDto().setType("person");
    }

    AnyPartyDto putAll(AnyPartyDto o);
    AnyPartyDto removeWhereEqual(AnyPartyDto o);
    boolean hasNoOptionalProperties();
    List<String> missingRequiredFields(String prefix);

    default void copyToOrganization(OrganizationDto o) {
    }
    default void copyToPerson(PersonDto o) {
    }
}