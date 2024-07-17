package io.github.jhannes.openapi.bigExample.model;

import java.time.LocalDate;
import lombok.*;

@Data
public final class PetDto {

    private String pet_type;
    private String name = null;
    private LocalDate birth_date = null;

}