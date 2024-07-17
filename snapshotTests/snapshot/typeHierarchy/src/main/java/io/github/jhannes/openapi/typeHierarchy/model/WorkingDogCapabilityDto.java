package io.github.jhannes.openapi.typeHierarchy.model;

import lombok.*;

@Getter
@RequiredArgsConstructor
public enum WorkingDogCapabilityDto {
    GUIDE("Guide"),
    RESCUE("Rescue"),
    SEARCH("Search");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}