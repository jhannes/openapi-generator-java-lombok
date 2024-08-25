package io.github.jhannes.openapi.serverHealth.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class ExceptionDto {

    private String type;
    private String message = null;
    private List<StackTraceInnerDto> stackTrace = new ArrayList<>();

    public boolean isEmpty() {
        return getMessage() == null
                && getStackTrace() == null
        ;
    }

    public ExceptionDto putAll(ExceptionDto o) {
        if (o.getType() != null) setType(o.getType());
        if (o.getMessage() != null) setMessage(o.getMessage());
        if (o.getStackTrace() != null) setStackTrace(o.getStackTrace());
        return this;
    }

    public ExceptionDto removeWhereEqual(ExceptionDto o) {
        if (Objects.equals(getMessage(), o.getMessage())) setMessage(null);
        if (Objects.equals(getStackTrace(), o.getStackTrace())) setStackTrace(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        return fields;
    }

}