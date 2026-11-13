package io.github.jhannes.openapi.typeHierarchyAllOf.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public sealed class PetBaseDto extends PetDto permits CatDto, DogDto {

    private String id = null;
    private String name;
    private String birth_date = null;
    private AddressDto ownerAddress = null;

    @Override
    public PetBaseDto setPetType(String petType) {
        super.setPetType(petType);
        return this;
    }

    public boolean hasNoOptionalProperties() {
        return super.hasNoOptionalProperties()
                && getId() == null
                && getBirth_date() == null
                && getOwnerAddress() == null
        ;
    }

    public PetBaseDto putAll(PetBaseDto o) {
        o.copyToPetBase(this);
        return this;
    }

    public PetBaseDto putAll(PetDto o) {
        o.copyToPetBase(this);
        return this;
    }

    public PetBaseDto removeWhereEqual(PetBaseDto o) {
        o.removeWhereEqualFromPetBase(this);
        return this;
    }

    public PetBaseDto removeWhereEqual(PetDto o) {
        o.removeWhereEqualFromPetBase(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = super.missingRequiredFields(prefix);
        if (getName() == null) fields.add(prefix + "name");
        if (getOwnerAddress() != null) {
            fields.addAll(getOwnerAddress().missingRequiredFields(prefix + "ownerAddress."));
        }
        return fields;
    }

    public void copyToPetBase(PetBaseDto o) {
        copyToPet(o);
        if (getId() != null) o.setId(getId());
        if (getName() != null) o.setName(getName());
        if (getBirth_date() != null) o.setBirth_date(getBirth_date());
        if (getOwnerAddress() != null) o.setOwnerAddress(getOwnerAddress());
    }

    public void copyToCat(CatDto o) {
        copyToPetBase(o);
    }

    public void copyToDog(DogDto o) {
        copyToPetBase(o);
    }

    public void removeWhereEqualFromPetBase(PetBaseDto o) {
        removeWhereEqualFromPet(o);
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getBirth_date(), o.getBirth_date())) o.setBirth_date(null);
        if (Objects.equals(getOwnerAddress(), o.getOwnerAddress())) o.setOwnerAddress(null);
    }

    public void removeWhereEqualFromCat(CatDto o) {
        removeWhereEqualFromPetBase(o);
    }

    public void removeWhereEqualFromDog(DogDto o) {
        removeWhereEqualFromPetBase(o);
    }
}