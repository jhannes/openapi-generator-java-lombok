package io.github.jhannes.openapi.typeHierarchy.model;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

@Data
public class GoldfishDto {
    @Getter @ToString @RequiredArgsConstructor
    public enum PetTypeEnum {
        GOLDFISH("Goldfish");
    
        private final String name;
    }

    private PetTypeEnum pet_type;
    private String name = null;
    private String species = null;

}