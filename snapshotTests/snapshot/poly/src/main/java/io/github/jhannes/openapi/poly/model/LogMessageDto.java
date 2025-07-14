package io.github.jhannes.openapi.poly.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class LogMessageDto {

    private String message;
    private Object error = null;

    public boolean hasNoOptionalProperties() {
        return getError() == null
        ;
    }

    public LogMessageDto putAll(LogMessageDto o) {
        o.copyToLogMessage(this);
        return this;
    }

    public LogMessageDto removeWhereEqual(LogMessageDto o) {
        if (Objects.equals(getError(), o.getError())) setError(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getMessage() == null) fields.add(prefix + "message");
        return fields;
    }

    public void copyToLogMessage(LogMessageDto o) {
        if (getMessage() != null) o.setMessage(getMessage());
        if (getError() != null) o.setError(getError());
    }
}