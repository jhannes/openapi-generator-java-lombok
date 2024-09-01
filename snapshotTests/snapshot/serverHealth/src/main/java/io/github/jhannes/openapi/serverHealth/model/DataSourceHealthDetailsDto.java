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

    public boolean empty() {
        return getUrl() == null
                && getLastAliveTime() == null
                && getLastFailureException() == null
        ;
    }

    public DataSourceHealthDetailsDto putAll(DataSourceHealthDetailsDto o) {
        if (o.getUrl() != null) setUrl(o.getUrl());
        if (o.getLastAliveTime() != null) setLastAliveTime(o.getLastAliveTime());
        if (o.getLastFailureException() != null) setLastFailureException(o.getLastFailureException());
        return this;
    }

    public DataSourceHealthDetailsDto removeWhereEqual(DataSourceHealthDetailsDto o) {
        if (Objects.equals(getUrl(), o.getUrl())) setUrl(null);
        if (Objects.equals(getLastAliveTime(), o.getLastAliveTime())) setLastAliveTime(null);
        if (Objects.equals(getLastFailureException(), o.getLastFailureException())) setLastFailureException(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getLastFailureException() != null) {
            fields.addAll(getLastFailureException().missingRequiredFields(prefix + ".lastFailureException"));
        }
        return fields;
    }

}