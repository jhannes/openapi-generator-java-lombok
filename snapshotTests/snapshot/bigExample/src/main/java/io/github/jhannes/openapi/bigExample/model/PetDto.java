package io.github.jhannes.openapi.bigExample.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class PetDto {

    private String pet_type;
    private String name = null;
    private LocalDate birth_date = null;

    public boolean hasNoOptionalProperties() {
        return getName() == null
                && getBirth_date() == null
        ;
    }

    public PetDto putAll(PetDto o) {
        o.copyToPet(this);
        return this;
    }

    public PetDto removeWhereEqual(PetDto o) {
        if (Objects.equals(getName(), o.getName())) setName(null);
        if (Objects.equals(getBirth_date(), o.getBirth_date())) setBirth_date(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getPet_type() == null) fields.add(prefix + "pet_type");
        return fields;
    }

    public void copyToPet(PetDto o) {
        if (getPet_type() != null) o.setPet_type(getPet_type());
        if (getName() != null) o.setName(getName());
        if (getBirth_date() != null) o.setBirth_date(getBirth_date());
    }
}