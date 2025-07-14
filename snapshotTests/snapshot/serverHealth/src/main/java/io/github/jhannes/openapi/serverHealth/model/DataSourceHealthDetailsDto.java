package io.github.jhannes.openapi.serverHealth.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class DataSourceHealthDetailsDto implements HealthDetailsDto {

    private String type = "DataSourceHealthDetails";
    private String url = null;
    private OffsetDateTime lastAliveTime = null;
    private ExceptionDto lastFailureException = null;

    public boolean hasNoOptionalProperties() {
        return getUrl() == null
                && getLastAliveTime() == null
                && getLastFailureException() == null
        ;
    }

    public DataSourceHealthDetailsDto putAll(DataSourceHealthDetailsDto o) {
        o.copyToDataSourceHealthDetails(this);
        return this;
    }

    public DataSourceHealthDetailsDto putAll(HealthDetailsDto o) {
        o.copyToDataSourceHealthDetails(this);
        return this;
    }

    public DataSourceHealthDetailsDto removeWhereEqual(DataSourceHealthDetailsDto o) {
        if (Objects.equals(getUrl(), o.getUrl())) setUrl(null);
        if (Objects.equals(getLastAliveTime(), o.getLastAliveTime())) setLastAliveTime(null);
        if (Objects.equals(getLastFailureException(), o.getLastFailureException())) setLastFailureException(null);
        return this;
    }

    public DataSourceHealthDetailsDto removeWhereEqual(HealthDetailsDto o) {
        if (o instanceof DataSourceHealthDetailsDto same) removeWhereEqual(same);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getLastFailureException() != null) {
            fields.addAll(getLastFailureException().missingRequiredFields(prefix + "lastFailureException."));
        }
        return fields;
    }

    public void copyToDataSourceHealthDetails(DataSourceHealthDetailsDto o) {
        if (getUrl() != null) o.setUrl(getUrl());
        if (getLastAliveTime() != null) o.setLastAliveTime(getLastAliveTime());
        if (getLastFailureException() != null) o.setLastFailureException(getLastFailureException());
    }
}