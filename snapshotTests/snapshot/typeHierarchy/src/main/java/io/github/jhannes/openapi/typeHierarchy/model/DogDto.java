package io.github.jhannes.openapi.typeHierarchy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
public sealed class DogDto extends PetBaseDto implements PetDto permits WorkingDogDto {

    @Getter
    @RequiredArgsConstructor
    public enum BreedEnum {
        Dingo("Dingo"),
        Husky("Husky"),
        Retriever("Retriever"),
        Shepherd("Shepherd");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    private String pet_type = "Dog";
    private Boolean bark = null;
    private BreedEnum breed = null;

    @Override
    public DogDto setId(String id) {
        super.setId(id);
        return this;
    }

    @Override
    public DogDto setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public DogDto setBirth_date(String birthDate) {
        super.setBirth_date(birthDate);
        return this;
    }

    @Override
    public DogDto setOwnerAddress(AddressDto ownerAddress) {
        super.setOwnerAddress(ownerAddress);
        return this;
    }

    public boolean hasNoOptionalProperties() {
        return super.hasNoOptionalProperties()
                && getBark() == null
                && getBreed() == null
        ;
    }

    public DogDto putAll(PetBaseDto o) {
        super.putAll(o);
        return this;
    }

    public DogDto putAll(DogDto o) {
        super.putAll(o);
        if (o.getBark() != null) setBark(o.getBark());
        if (o.getBreed() != null) setBreed(o.getBreed());
        return this;
    }

    public DogDto putAll(PetDto o) {
        if (o instanceof PetBaseDto base) putAll(base);
        return this;
    }

    public DogDto removeWhereEqual(DogDto o) {
        super.removeWhereEqual(o);
        if (Objects.equals(getBark(), o.getBark())) setBark(null);
        if (Objects.equals(getBreed(), o.getBreed())) setBreed(null);
        return this;
    }

    public DogDto removeWhereEqual(PetDto o) {
        if (o instanceof PetBaseDto base) removeWhereEqual(base);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = super.missingRequiredFields(prefix);
        if (getPet_type() == null) fields.add(prefix + "pet_type");
        return fields;
    }

}