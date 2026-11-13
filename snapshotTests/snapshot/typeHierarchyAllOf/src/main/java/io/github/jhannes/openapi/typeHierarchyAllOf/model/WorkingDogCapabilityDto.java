package io.github.jhannes.openapi.typeHierarchyAllOf.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WorkingDogCapabilityDto {
    Guide("Guide"),
    Rescue("Rescue"),
    Search("Search");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}