package io.github.jhannes.openapi.bigExample.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.*;

@Data
public final class PetLocationsDto {

    private Map<String, Map<String, List<Double>>> locations = new HashMap<>();

}