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

    public boolean empty() {
        return getName() == null
                && getSpecies() == null
        ;
    }

    public GoldfishDto putAll(GoldfishDto o) {
        if (o.getPet_type() != null) setPet_type(o.getPet_type());
        if (o.getName() != null) setName(o.getName());
        if (o.getSpecies() != null) setSpecies(o.getSpecies());
        return this;
    }

    public GoldfishDto removeWhereEqual(GoldfishDto o) {
        if (Objects.equals(getName(), o.getName())) setName(null);
        if (Objects.equals(getSpecies(), o.getSpecies())) setSpecies(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getPet_type() == null) fields.add(prefix + "petType");
        return fields;
    }

}