package io.github.jhannes.openapi.typeHierarchy.model;

import io.github.jhannes.openapi.typeHierarchy.model.AddressDto;
import lombok.Data;

@Data
public class PetBaseDto {

    private String id = null;
    private String name;
    private String birth_date = null;
    private AddressDto ownerAddress = null;

}