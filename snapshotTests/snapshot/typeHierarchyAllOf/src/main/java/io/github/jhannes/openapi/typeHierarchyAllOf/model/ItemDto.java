package io.github.jhannes.openapi.typeHierarchyAllOf.model;

import java.util.List;

public sealed interface ItemDto permits FoodDto, PetDto {

    String getType();

    static Class<? extends ItemDto> getType(String type) {
        return switch (type) {
            case "Food" -> FoodDto.class;
            case "Pet" -> PetDto.class;
            default -> throw new IllegalArgumentException("Illegal type " + type);
        };
    }

    static FoodDto createFood() {
        return new FoodDto();
    }

    ItemDto putAll(ItemDto o);
    ItemDto removeWhereEqual(ItemDto o);
    boolean hasNoOptionalProperties();
    List<String> missingRequiredFields(String prefix);

    default void copyToCat(CatDto o) {
    }
    default void copyToDog(DogDto o) {
    }
    default void copyToFood(FoodDto o) {
    }
    default void copyToGoldfish(GoldfishDto o) {
    }
    default void copyToPet(PetDto o) {
    }
    default void copyToPetBase(PetBaseDto o) {
    }
    default void copyToWorkingDog(WorkingDogDto o) {
    }
    default void removeWhereEqualFromCat(CatDto o) {
    }
    default void removeWhereEqualFromDog(DogDto o) {
    }
    default void removeWhereEqualFromFood(FoodDto o) {
    }
    default void removeWhereEqualFromGoldfish(GoldfishDto o) {
    }
    default void removeWhereEqualFromPet(PetDto o) {
    }
    default void removeWhereEqualFromPetBase(PetBaseDto o) {
    }
    default void removeWhereEqualFromWorkingDog(WorkingDogDto o) {
    }
}