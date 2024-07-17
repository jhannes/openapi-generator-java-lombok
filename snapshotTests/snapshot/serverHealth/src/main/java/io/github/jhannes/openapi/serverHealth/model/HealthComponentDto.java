package io.github.jhannes.openapi.serverHealth.model;

import io.github.jhannes.openapi.serverHealth.model.HealthStatusDto;
import java.time.OffsetDateTime;
import lombok.*;

@Data
public final class HealthComponentDto {

    private HealthStatusDto status;
    private HealthDetailsDto details;
    private OffsetDateTime time = null;

}