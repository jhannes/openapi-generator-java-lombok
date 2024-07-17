package io.github.jhannes.openapi.poly.model;

import lombok.*;

public sealed interface AnyPartyDto permits OrganizationDto, PersonDto {

    static Class<? extends AnyPartyDto> getType(String type) {
        return switch (type) {
            case "organization" -> OrganizationDto.class;
            case "person" -> PersonDto.class;
            default -> throw new IllegalArgumentException("Illegal type " + type);
        };
    }
}