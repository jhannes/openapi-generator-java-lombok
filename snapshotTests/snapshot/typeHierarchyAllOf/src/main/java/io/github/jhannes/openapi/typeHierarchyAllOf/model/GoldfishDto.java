package io.github.jhannes.openapi.typeHierarchyAllOf.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public final class GoldfishDto extends PetDto {

    private String name = null;
    private String species;

    @Override
    public GoldfishDto setPetType(String petType) {
        super.setPetType(petType);
        return this;
    }

    public boolean hasNoOptionalProperties() {
        return super.hasNoOptionalProperties()
                && getName() == null
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
        List<String> fields = super.missingRequiredFields(prefix);
        if (getSpecies() == null) fields.add(prefix + "species");
        return fields;
    }

    public void copyToGoldfish(GoldfishDto o) {
        copyToPet(o);
        if (getName() != null) o.setName(getName());
        if (getSpecies() != null) o.setSpecies(getSpecies());
    }

    public void removeWhereEqualFromGoldfish(GoldfishDto o) {
        removeWhereEqualFromPet(o);
        if (Objects.equals(getName(), o.getName())) o.setName(null);
    }
}