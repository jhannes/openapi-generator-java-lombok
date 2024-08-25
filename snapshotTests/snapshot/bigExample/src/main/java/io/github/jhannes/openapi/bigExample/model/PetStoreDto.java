package io.github.jhannes.openapi.bigExample.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Data;

@Data
public final class PetStoreDto {

    private Map<String, PetDto> pets = new HashMap<>();

    public boolean isEmpty() {
        return getPets() == null
        ;
    }

    public PetStoreDto putAll(PetStoreDto o) {
        if (o.getPets() != null) setPets(o.getPets());
        return this;
    }

    public PetStoreDto removeWhereEqual(PetStoreDto o) {
        if (Objects.equals(getPets(), o.getPets())) setPets(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}