package io.github.jhannes.openapi.serverHealth.model;

import io.github.jhannes.openapi.serverHealth.model.HealthStatusDto;
import java.util.HashMap;
import java.util.Map;
import lombok.*;

@Data
public final class HealthSummaryDto {

    private HealthStatusDto status;
    private Map<String, HealthComponentDto> components = new HashMap<>();

}