package io.github.jhannes.openapi.bigExample.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Data;

@Data
public final class PetLocationsDto {

    private Map<String, Map<String, List<Double>>> locations = new HashMap<>();

    public boolean hasNoOptionalProperties() {
        return getLocations() == null
        ;
    }

    public PetLocationsDto putAll(PetLocationsDto o) {
        if (o.getLocations() != null) setLocations(o.getLocations());
        return this;
    }

    public PetLocationsDto removeWhereEqual(PetLocationsDto o) {
        if (Objects.equals(getLocations(), o.getLocations())) setLocations(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

}