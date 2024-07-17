package io.github.jhannes.openapi.bigExample.model;

import java.util.HashMap;
import java.util.Map;
import lombok.*;

@Data
public final class PetStoreDto {

    private Map<String, PetDto> pets = new HashMap<>();

}