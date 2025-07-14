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

    public boolean hasNoOptionalProperties() {
        return getMessage() == null
                && getStackTrace() == null
        ;
    }

    public ExceptionDto putAll(ExceptionDto o) {
        o.copyToException(this);
        return this;
    }

    public ExceptionDto removeWhereEqual(ExceptionDto o) {
        o.removeWhereEqualFromException(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getStackTrace() != null) {
            for (int i = 0; i < getStackTrace().size(); i++) {
                fields.addAll(getStackTrace().get(i).missingRequiredFields(prefix + "stackTrace[" + i + "]."));
            }
        }
        return fields;
    }

    public void copyToException(ExceptionDto o) {
        if (getType() != null) o.setType(getType());
        if (getMessage() != null) o.setMessage(getMessage());
        if (getStackTrace() != null) o.setStackTrace(getStackTrace());
    }

    public void removeWhereEqualFromException(ExceptionDto o) {
        if (Objects.equals(getMessage(), o.getMessage())) o.setMessage(null);
        if (Objects.equals(getStackTrace(), o.getStackTrace())) o.setStackTrace(null);
    }
}