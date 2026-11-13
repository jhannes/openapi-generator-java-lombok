package io.github.jhannes.openapi.typeHierarchyAllOf.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public final class CatDto extends PetBaseDto {

    private Boolean hunts;
    private Integer age = null;

    @Override
    public CatDto setPetType(String petType) {
        super.setPetType(petType);
        return this;
    }

    @Override
    public CatDto setId(String id) {
        super.setId(id);
        return this;
    }

    @Override
    public CatDto setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public CatDto setBirth_date(String birthDate) {
        super.setBirth_date(birthDate);
        return this;
    }

    @Override
    public CatDto setOwnerAddress(AddressDto ownerAddress) {
        super.setOwnerAddress(ownerAddress);
        return this;
    }

    public boolean hasNoOptionalProperties() {
        return super.hasNoOptionalProperties()
                && getAge() == null
        ;
    }

    public CatDto putAll(CatDto o) {
        o.copyToCat(this);
        return this;
    }

    public CatDto putAll(PetBaseDto o) {
        o.copyToCat(this);
        return this;
    }

    public CatDto removeWhereEqual(CatDto o) {
        o.removeWhereEqualFromCat(this);
        return this;
    }

    public CatDto removeWhereEqual(PetBaseDto o) {
        o.removeWhereEqualFromCat(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = super.missingRequiredFields(prefix);
        if (getHunts() == null) fields.add(prefix + "hunts");
        return fields;
    }

    public void copyToCat(CatDto o) {
        copyToPetBase(o);
        if (getHunts() != null) o.setHunts(getHunts());
        if (getAge() != null) o.setAge(getAge());
    }

    public void removeWhereEqualFromCat(CatDto o) {
        removeWhereEqualFromPetBase(o);
        if (Objects.equals(getAge(), o.getAge())) o.setAge(null);
    }
}