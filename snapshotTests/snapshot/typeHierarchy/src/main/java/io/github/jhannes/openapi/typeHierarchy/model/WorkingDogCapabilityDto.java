package io.github.jhannes.openapi.typeHierarchy.model;

import lombok.Getter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@ToString
public enum WorkingDogCapabilityDto {
    GUIDE("Guide"),
    RESCUE("Rescue"),
    SEARCH("Search");

    private final String name;
}