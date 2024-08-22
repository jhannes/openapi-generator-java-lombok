package io.github.jhannes.openapi.typeHierarchy.model;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public final class CatDto extends PetBaseDto implements PetDto {

    private String pet_type = "Cat";
    private Boolean hunts = null;
    private Integer age = null;

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

}