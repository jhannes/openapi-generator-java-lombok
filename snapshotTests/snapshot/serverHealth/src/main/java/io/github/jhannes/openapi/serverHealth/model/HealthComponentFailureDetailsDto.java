package io.github.jhannes.openapi.serverHealth.model;

import lombok.*;

@Data
public final class HealthComponentFailureDetailsDto implements HealthDetailsDto {

    private String type = "HealthComponentFailureDetails";
    private ExceptionDto exception = null;

}