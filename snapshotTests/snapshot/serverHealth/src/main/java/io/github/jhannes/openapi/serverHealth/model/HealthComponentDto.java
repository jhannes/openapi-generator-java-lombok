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

    public boolean empty() {
        return getTime() == null
        ;
    }

    public HealthComponentDto putAll(HealthComponentDto o) {
        if (o.getStatus() != null) setStatus(o.getStatus());
        if (o.getDetails() != null) setDetails(o.getDetails());
        if (o.getTime() != null) setTime(o.getTime());
        return this;
    }

    public HealthComponentDto removeWhereEqual(HealthComponentDto o) {
        if (Objects.equals(getTime(), o.getTime())) setTime(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getStatus() == null) fields.add(prefix + "status");
        if (getDetails() == null) fields.add(prefix + "details");
        return fields;
    }

}