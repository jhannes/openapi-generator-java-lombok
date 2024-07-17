package io.github.jhannes.openapi.typeHierarchy.model;

import lombok.*;

@Getter
@RequiredArgsConstructor
@ToString
public enum WorkingDogCapabilityDto {
    GUIDE("Guide"),
    RESCUE("Rescue"),
    SEARCH("Search");

    private final String name;
}