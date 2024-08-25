package io.github.jhannes.openapi.typeHierarchy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

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