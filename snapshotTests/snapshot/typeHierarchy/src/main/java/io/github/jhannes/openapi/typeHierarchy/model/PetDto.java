package io.github.jhannes.openapi.typeHierarchy.model;

import java.util.List;

public sealed interface PetDto permits CatDto, DogDto, GoldfishDto, WorkingDogDto {

    String getPet_type();

    static Class<? extends PetDto> getType(String pet_type) {
        return switch (pet_type) {
            case "WorkingDog" -> WorkingDogDto.class;
            case "Cat" -> CatDto.class;
            case "Goldfish" -> GoldfishDto.class;
            case "Dog" -> DogDto.class;
            default -> throw new IllegalArgumentException("Illegal pet_type " + pet_type);
        };
    }

    static WorkingDogDto createWorkingDog() {
        return new WorkingDogDto().setPet_type("WorkingDog");
    }

    static CatDto createCat() {
        return new CatDto().setPet_type("Cat");
    }

    static GoldfishDto createGoldfish() {
        return new GoldfishDto().setPet_type("Goldfish");
    }

    static DogDto createDog() {
        return new DogDto().setPet_type("Dog");
    }

    PetDto putAll(PetDto o);
    PetDto removeWhereEqual(PetDto o);
    boolean hasNoOptionalProperties();
    List<String> missingRequiredFields(String prefix);
}