package io.github.jhannes.openapi.typeHierarchy.model;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public final class CatDto extends PetBaseDto implements PetDto {

    private String pet_type = "Cat";
    private Boolean hunts = null;
    private Integer age = null;

}