package io.github.jhannes.openapi.typeHierarchy.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public final class WorkingDogDto extends DogDto implements PetDto {

    private String pet_type = "WorkingDog";
    private List<WorkingDogCapabilityDto> capabilities = new ArrayList<>();

}