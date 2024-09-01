package io.github.jhannes.openapi.poly.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class LogMessageDto {

    private String message;
    private Object error = null;

    public boolean empty() {
        return getError() == null
        ;
    }

    public LogMessageDto putAll(LogMessageDto o) {
        if (o.getMessage() != null) setMessage(o.getMessage());
        if (o.getError() != null) setError(o.getError());
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

}