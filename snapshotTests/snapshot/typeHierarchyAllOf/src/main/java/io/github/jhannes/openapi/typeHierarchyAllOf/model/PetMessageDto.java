package io.github.jhannes.openapi.typeHierarchyAllOf.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class PetMessageDto {

    private PetDto pet;

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public PetMessageDto putAll(PetMessageDto o) {
        o.copyToPetMessage(this);
        return this;
    }

    public PetMessageDto removeWhereEqual(PetMessageDto o) {
        o.removeWhereEqualFromPetMessage(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getPet() != null) {
            fields.addAll(getPet().missingRequiredFields(prefix + "pet."));
        } else {
            fields.add(prefix + "pet");
        }
        return fields;
    }

    public void copyToPetMessage(PetMessageDto o) {
        if (getPet() != null) o.setPet(getPet());
    }

    public void removeWhereEqualFromPetMessage(PetMessageDto o) {
    }
}