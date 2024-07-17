package io.github.jhannes.openapi.serverHealth.model;

import java.time.OffsetDateTime;
import lombok.*;

@Data
public final class DataSourceHealthDetailsDto implements HealthDetailsDto {

    private String type = "DataSourceHealthDetails";
    private String url = null;
    private OffsetDateTime lastAliveTime = null;
    private ExceptionDto lastFailureException = null;

}