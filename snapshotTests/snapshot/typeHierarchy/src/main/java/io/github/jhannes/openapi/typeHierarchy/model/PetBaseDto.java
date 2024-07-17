package io.github.jhannes.openapi.typeHierarchy.model;

import lombok.*;

@Data
public sealed class PetBaseDto permits CatDto, DogDto {

    private String id = null;
    private String name;
    private String birth_date = null;
    private AddressDto ownerAddress = null;

}