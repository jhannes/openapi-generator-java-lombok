package io.github.jhannes.openapi.typeHierarchy.model;

import lombok.*;

@Data
public final class GoldfishDto implements PetDto {

    private String pet_type = "Goldfish";
    private String name = null;
    private String species = null;

}