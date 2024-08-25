package io.github.jhannes.openapi.serverHealth.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class HealthComponentFailureDetailsDto implements HealthDetailsDto {

    private String type = "HealthComponentFailureDetails";
    private ExceptionDto exception = null;

    public boolean isEmpty() {
        return getException() == null
        ;
    }

    public HealthComponentFailureDetailsDto putAll(HealthComponentFailureDetailsDto o) {
        if (o.getException() != null) setException(o.getException());
        return this;
    }

    public HealthComponentFailureDetailsDto removeWhereEqual(HealthComponentFailureDetailsDto o) {
        if (Objects.equals(getException(), o.getException())) setException(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getException() != null) {
            fields.addAll(getException().missingRequiredFields(prefix + ".exception"));
        }
        return fields;
    }

}