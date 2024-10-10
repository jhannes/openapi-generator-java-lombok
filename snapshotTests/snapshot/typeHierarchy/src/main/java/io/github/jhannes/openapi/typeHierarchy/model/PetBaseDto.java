package io.github.jhannes.openapi.typeHierarchy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public sealed class PetBaseDto permits CatDto, DogDto {

    private String id = null;
    private String name;
    private String birth_date = null;
    private AddressDto ownerAddress = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getBirth_date() == null
                && getOwnerAddress() == null
        ;
    }

    public PetBaseDto putAll(PetBaseDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getName() != null) setName(o.getName());
        if (o.getBirth_date() != null) setBirth_date(o.getBirth_date());
        if (o.getOwnerAddress() != null) setOwnerAddress(o.getOwnerAddress());
        return this;
    }

    public PetBaseDto removeWhereEqual(PetBaseDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getBirth_date(), o.getBirth_date())) setBirth_date(null);
        if (Objects.equals(getOwnerAddress(), o.getOwnerAddress())) setOwnerAddress(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getName() == null) fields.add(prefix + "name");
        if (getOwnerAddress() != null) {
            fields.addAll(getOwnerAddress().missingRequiredFields(prefix + ".ownerAddress"));
        }
        return fields;
    }

}