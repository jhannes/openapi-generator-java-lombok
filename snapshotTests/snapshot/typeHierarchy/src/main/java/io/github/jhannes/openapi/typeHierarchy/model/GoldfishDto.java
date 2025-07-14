package io.github.jhannes.openapi.typeHierarchy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class GoldfishDto implements PetDto {

    private String pet_type = "Goldfish";
    private String name = null;
    private String species = null;

    public boolean hasNoOptionalProperties() {
        return getName() == null
                && getSpecies() == null
        ;
    }

    public GoldfishDto putAll(GoldfishDto o) {
        o.copyToGoldfish(this);
        return this;
    }

    public GoldfishDto putAll(PetDto o) {
        o.copyToGoldfish(this);
        return this;
    }

    public GoldfishDto removeWhereEqual(GoldfishDto o) {
        o.removeWhereEqualFromGoldfish(this);
        return this;
    }

    public GoldfishDto removeWhereEqual(PetDto o) {
        o.removeWhereEqualFromGoldfish(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getPet_type() == null) fields.add(prefix + "pet_type");
        return fields;
    }

    public void copyToGoldfish(GoldfishDto o) {
        if (getName() != null) o.setName(getName());
        if (getSpecies() != null) o.setSpecies(getSpecies());
    }

    public void removeWhereEqualFromGoldfish(GoldfishDto o) {
        if (Objects.equals(getName(), o.getName())) o.setName(null);
        if (Objects.equals(getSpecies(), o.getSpecies())) o.setSpecies(null);
    }
}