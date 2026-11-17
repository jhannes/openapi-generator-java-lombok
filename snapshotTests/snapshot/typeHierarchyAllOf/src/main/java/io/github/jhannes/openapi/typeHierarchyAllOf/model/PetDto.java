package io.github.jhannes.openapi.typeHierarchyAllOf.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public abstract sealed class PetDto implements ItemDto permits GoldfishDto, PetBaseDto {

    public static Class<? extends PetDto> getType(String petType) {
        return switch (petType) {
            case "Cat" -> CatDto.class;
            case "Dog" -> DogDto.class;
            case "Goldfish" -> GoldfishDto.class;
            case "WorkingDog" -> WorkingDogDto.class;
            default -> throw new IllegalArgumentException("Illegal petType " + petType);
        };
    }

    public static CatDto createCat() {
        return new CatDto();
    }

    public static DogDto createDog() {
        return new DogDto();
    }

    public static GoldfishDto createGoldfish() {
        return new GoldfishDto();
    }

    public static WorkingDogDto createWorkingDog() {
        return new WorkingDogDto();
    }

    private final String type = "Pet";
    private final String petType;

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public PetDto putAll(PetDto o) {
        o.copyToPet(this);
        return this;
    }

    public PetDto putAll(ItemDto o) {
        o.copyToPet(this);
        return this;
    }

    public PetDto removeWhereEqual(PetDto o) {
        o.removeWhereEqualFromPet(this);
        return this;
    }

    public PetDto removeWhereEqual(ItemDto o) {
        o.removeWhereEqualFromPet(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getPetType() == null) fields.add(prefix + "petType");
        return fields;
    }

    public void copyToPet(PetDto o) {
    }

    public void copyToGoldfish(GoldfishDto o) {
        copyToPet(o);
    }

    public void copyToPetBase(PetBaseDto o) {
        copyToPet(o);
    }

    public void copyToCat(CatDto o) {
        copyToPet(o);
    }

    public void copyToDog(DogDto o) {
        copyToPet(o);
    }

    public void copyToWorkingDog(WorkingDogDto o) {
        copyToPet(o);
    }

    public void removeWhereEqualFromPet(PetDto o) {
    }

    public void removeWhereEqualFromGoldfish(GoldfishDto o) {
        removeWhereEqualFromPet(o);
    }

    public void removeWhereEqualFromPetBase(PetBaseDto o) {
        removeWhereEqualFromPet(o);
    }
}