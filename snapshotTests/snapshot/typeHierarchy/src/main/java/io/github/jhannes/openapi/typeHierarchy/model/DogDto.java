package io.github.jhannes.openapi.typeHierarchy.model;

import io.github.jhannes.openapi.typeHierarchy.model.AddressDto;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

@Data
public class DogDto {
    @Getter @ToString @RequiredArgsConstructor
    public enum BreedEnum {
        DINGO("Dingo"),
        HUSKY("Husky"),
        RETRIEVER("Retriever"),
        SHEPHERD("Shepherd");
    
        private final String name;
    }
    @Getter @ToString @RequiredArgsConstructor
    public enum PetTypeEnum {
        DOG("Dog");
    
        private final String name;
    }

    private String id = null;
    private String name;
    private String birth_date = null;
    private AddressDto ownerAddress = null;
    private Boolean bark = null;
    private BreedEnum breed = null;
    private PetTypeEnum pet_type;

}