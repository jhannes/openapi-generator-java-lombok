package io.github.jhannes.openapi.typeHierarchy.model;

import java.util.List;

public sealed interface PetDto permits CatDto, DogDto, GoldfishDto, WorkingDogDto {

    String getPet_type();

    static Class<? extends PetDto> getType(String pet_type) {
        return switch (pet_type) {
            case "Cat" -> CatDto.class;
            case "Dog" -> DogDto.class;
            case "Goldfish" -> GoldfishDto.class;
            case "WorkingDog" -> WorkingDogDto.class;
            default -> throw new IllegalArgumentException("Illegal pet_type " + pet_type);
        };
    }

    static CatDto createCat() {
        return new CatDto();
    }

    static DogDto createDog() {
        return new DogDto();
    }

    static GoldfishDto createGoldfish() {
        return new GoldfishDto();
    }

    static WorkingDogDto createWorkingDog() {
        return new WorkingDogDto();
    }

    PetDto putAll(PetDto o);
    PetDto removeWhereEqual(PetDto o);
    boolean hasNoOptionalProperties();
    List<String> missingRequiredFields(String prefix);

    default void copyToCat(CatDto o) {
    }
    default void copyToDog(DogDto o) {
    }
    default void copyToGoldfish(GoldfishDto o) {
    }
    default void copyToWorkingDog(WorkingDogDto o) {
    }
    default void removeWhereEqualFromCat(CatDto o) {
    }
    default void removeWhereEqualFromDog(DogDto o) {
    }
    default void removeWhereEqualFromGoldfish(GoldfishDto o) {
    }
    default void removeWhereEqualFromWorkingDog(WorkingDogDto o) {
    }
}