package io.github.jhannes.openapi.serverHealth.model;

import io.github.jhannes.openapi.serverHealth.model.HealthStatusDto;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class HealthComponentDto {

    private HealthStatusDto status;
    private HealthDetailsDto details;
    private OffsetDateTime time = null;

    public boolean hasNoOptionalProperties() {
        return getTime() == null
        ;
    }

    public HealthComponentDto putAll(HealthComponentDto o) {
        o.copyToHealthComponent(this);
        return this;
    }

    public HealthComponentDto removeWhereEqual(HealthComponentDto o) {
        if (Objects.equals(getTime(), o.getTime())) setTime(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getStatus() == null) fields.add(prefix + "status");
        if (getDetails() != null) {
            fields.addAll(getDetails().missingRequiredFields(prefix + "details."));
        } else {
            fields.add(prefix + "details");
        }
        return fields;
    }

    public void copyToHealthComponent(HealthComponentDto o) {
        if (getStatus() != null) o.setStatus(getStatus());
        if (getDetails() != null) o.setDetails(getDetails());
        if (getTime() != null) o.setTime(getTime());
    }
}