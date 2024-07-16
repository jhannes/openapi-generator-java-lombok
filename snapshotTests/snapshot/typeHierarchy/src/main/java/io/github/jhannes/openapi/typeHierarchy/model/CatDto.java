package io.github.jhannes.openapi.typeHierarchy.model;

import io.github.jhannes.openapi.typeHierarchy.model.AddressDto;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

@Data
public class CatDto {
    @Getter @ToString @RequiredArgsConstructor
    public enum PetTypeEnum {
        CAT("Cat");
    
        private final String name;
    }

    private String id = null;
    private String name;
    private String birth_date = null;
    private AddressDto ownerAddress = null;
    private PetTypeEnum pet_type;
    private Boolean hunts = null;
    private Integer age = null;

}