package io.github.jhannes.openapi.typeHierarchy.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public final class WorkingDogDto extends DogDto implements PetDto {

    private String pet_type = "WorkingDog";
    private List<WorkingDogCapabilityDto> capabilities = new ArrayList<>();

    @Override
    public WorkingDogDto setId(String id) {
        super.setId(id);
        return this;
    }

    @Override
    public WorkingDogDto setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public WorkingDogDto setBirth_date(String birthDate) {
        super.setBirth_date(birthDate);
        return this;
    }

    @Override
    public WorkingDogDto setOwnerAddress(AddressDto ownerAddress) {
        super.setOwnerAddress(ownerAddress);
        return this;
    }

    @Override
    public WorkingDogDto setBark(Boolean bark) {
        super.setBark(bark);
        return this;
    }

    @Override
    public WorkingDogDto setBreed(BreedEnum breed) {
        super.setBreed(breed);
        return this;
    }

}