package io.github.jhannes.openapi.typeHierarchy.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    public boolean hasNoOptionalProperties() {
        return super.hasNoOptionalProperties()
        ;
    }

    public WorkingDogDto putAll(WorkingDogDto o) {
        o.copyToWorkingDog(this);
        return this;
    }

    public WorkingDogDto putAll(DogDto o) {
        o.copyToWorkingDog(this);
        return this;
    }

    public WorkingDogDto putAll(PetDto o) {
        o.copyToWorkingDog(this);
        return this;
    }

    public WorkingDogDto removeWhereEqual(WorkingDogDto o) {
        o.removeWhereEqualFromWorkingDog(this);
        return this;
    }

    public WorkingDogDto removeWhereEqual(DogDto o) {
        o.removeWhereEqualFromWorkingDog(this);
        return this;
    }

    public WorkingDogDto removeWhereEqual(PetDto o) {
        o.removeWhereEqualFromWorkingDog(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = super.missingRequiredFields(prefix);
        if (getPet_type() == null) fields.add(prefix + "pet_type");
        if (getCapabilities() == null) fields.add(prefix + "capabilities");
        return fields;
    }

    public void copyToWorkingDog(WorkingDogDto o) {
        copyToDog(o);
        if (getCapabilities() != null) o.setCapabilities(getCapabilities());
    }

    public void removeWhereEqualFromWorkingDog(WorkingDogDto o) {
        removeWhereEqualFromDog(o);
    }
}