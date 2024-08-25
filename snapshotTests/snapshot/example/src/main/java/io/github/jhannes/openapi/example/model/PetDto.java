package io.github.jhannes.openapi.example.model;

import io.github.jhannes.openapi.example.model.PetTypeDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

@Data
public final class PetDto {

    private PetTypeDto pet_type;
    private String name = null;
    private LocalDate birth_date = null;

    public boolean isEmpty() {
        return getName() == null
                && getBirth_date() == null
        ;
    }

    public PetDto putAll(PetDto o) {
        if (o.getPet_type() != null) setPet_type(o.getPet_type());
        if (o.getName() != null) setName(o.getName());
        if (o.getBirth_date() != null) setBirth_date(o.getBirth_date());
        return this;
    }

    public PetDto removeWhereEqual(PetDto o) {
        if (Objects.equals(getName(), o.getName())) setName(null);
        if (Objects.equals(getBirth_date(), o.getBirth_date())) setBirth_date(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getPet_type() == null) fields.add(prefix + "petType");
        return fields;
    }

}