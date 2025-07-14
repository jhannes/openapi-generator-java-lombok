package io.github.jhannes.openapi.serverHealth.model;

import io.github.jhannes.openapi.serverHealth.model.HealthStatusDto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public final class HealthSummaryDto {

    private HealthStatusDto status;
    private Map<String, HealthComponentDto> components = new HashMap<>();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public HealthSummaryDto putAll(HealthSummaryDto o) {
        o.copyToHealthSummary(this);
        return this;
    }

    public HealthSummaryDto removeWhereEqual(HealthSummaryDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getStatus() == null) fields.add(prefix + "status");
        if (getComponents() != null) {
            getComponents().forEach((key, value) -> fields.addAll(value.missingRequiredFields(prefix + "components[" + key + "].")));
        } else {
            fields.add(prefix + "components");
        }
        return fields;
    }

    public void copyToHealthSummary(HealthSummaryDto o) {
        if (getStatus() != null) o.setStatus(getStatus());
        if (getComponents() != null) o.setComponents(getComponents());
    }
}