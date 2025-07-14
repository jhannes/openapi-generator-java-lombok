package io.github.jhannes.openapi.bigExample.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Data;

@Data
public final class PetStoreDto {

    private Map<String, PetDto> pets = new HashMap<>();

    public boolean hasNoOptionalProperties() {
        return getPets() == null
        ;
    }

    public PetStoreDto putAll(PetStoreDto o) {
        o.copyToPetStore(this);
        return this;
    }

    public PetStoreDto removeWhereEqual(PetStoreDto o) {
        if (Objects.equals(getPets(), o.getPets())) setPets(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToPetStore(PetStoreDto o) {
        if (getPets() != null) o.setPets(getPets());
    }
}