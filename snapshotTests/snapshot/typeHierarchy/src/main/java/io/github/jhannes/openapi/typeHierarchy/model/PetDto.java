package io.github.jhannes.openapi.typeHierarchy.model;

import lombok.*;

public sealed interface PetDto permits WorkingDogDto, CatDto, GoldfishDto, DogDto {

    static Class<? extends PetDto> getType(String petType) {
        return switch (petType) {
            case "WorkingDog" -> WorkingDogDto.class;
            case "Cat" -> CatDto.class;
            case "Goldfish" -> GoldfishDto.class;
            case "Dog" -> DogDto.class;
            default -> throw new IllegalArgumentException("Illegal petType " + petType);
        };
    }
}