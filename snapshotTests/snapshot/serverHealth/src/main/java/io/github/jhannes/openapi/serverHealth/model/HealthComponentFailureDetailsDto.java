package io.github.jhannes.openapi.serverHealth.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class HealthComponentFailureDetailsDto implements HealthDetailsDto {

    private String type = "HealthComponentFailureDetails";
    private ExceptionDto exception = null;

    public boolean hasNoOptionalProperties() {
        return getException() == null
        ;
    }

    public HealthComponentFailureDetailsDto putAll(HealthComponentFailureDetailsDto o) {
        o.copyToHealthComponentFailureDetails(this);
        return this;
    }

    public HealthComponentFailureDetailsDto putAll(HealthDetailsDto o) {
        o.copyToHealthComponentFailureDetails(this);
        return this;
    }

    public HealthComponentFailureDetailsDto removeWhereEqual(HealthComponentFailureDetailsDto o) {
        o.removeWhereEqualFromHealthComponentFailureDetails(this);
        return this;
    }

    public HealthComponentFailureDetailsDto removeWhereEqual(HealthDetailsDto o) {
        o.removeWhereEqualFromHealthComponentFailureDetails(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getException() != null) {
            fields.addAll(getException().missingRequiredFields(prefix + "exception."));
        }
        return fields;
    }

    public void copyToHealthComponentFailureDetails(HealthComponentFailureDetailsDto o) {
        if (getException() != null) o.setException(getException());
    }

    public void removeWhereEqualFromHealthComponentFailureDetails(HealthComponentFailureDetailsDto o) {
        if (Objects.equals(getException(), o.getException())) o.setException(null);
    }
}