package io.github.jhannes.openapi.example.model;

import io.github.jhannes.openapi.example.model.PetTypeDto;
import java.time.LocalDate;
import lombok.*;

@Data
public final class PetDto {

    private PetTypeDto pet_type;
    private String name = null;
    private LocalDate birth_date = null;

}