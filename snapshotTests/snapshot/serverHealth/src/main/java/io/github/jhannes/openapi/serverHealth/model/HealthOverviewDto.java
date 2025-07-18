package io.github.jhannes.openapi.serverHealth.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public final class HealthOverviewDto {

    private Map<String, HealthStatusDto> components = new HashMap<>();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public HealthOverviewDto putAll(HealthOverviewDto o) {
        o.copyToHealthOverview(this);
        return this;
    }

    public HealthOverviewDto removeWhereEqual(HealthOverviewDto o) {
        o.removeWhereEqualFromHealthOverview(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getComponents() == null) fields.add(prefix + "components");
        return fields;
    }

    public void copyToHealthOverview(HealthOverviewDto o) {
        if (getComponents() != null) o.setComponents(getComponents());
    }

    public void removeWhereEqualFromHealthOverview(HealthOverviewDto o) {
    }
}