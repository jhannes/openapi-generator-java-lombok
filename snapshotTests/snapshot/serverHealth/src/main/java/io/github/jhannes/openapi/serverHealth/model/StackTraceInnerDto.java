package io.github.jhannes.openapi.serverHealth.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class StackTraceInnerDto {

    private String className;
    private String methodName;
    private String fileName;
    private Integer lineNumber;

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public StackTraceInnerDto putAll(StackTraceInnerDto o) {
        o.copyToStackTrace_inner(this);
        return this;
    }

    public StackTraceInnerDto removeWhereEqual(StackTraceInnerDto o) {
        o.removeWhereEqualFromStackTrace_inner(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getClassName() == null) fields.add(prefix + "className");
        if (getMethodName() == null) fields.add(prefix + "methodName");
        if (getFileName() == null) fields.add(prefix + "fileName");
        if (getLineNumber() == null) fields.add(prefix + "lineNumber");
        return fields;
    }

    public void copyToStackTrace_inner(StackTraceInnerDto o) {
        if (getClassName() != null) o.setClassName(getClassName());
        if (getMethodName() != null) o.setMethodName(getMethodName());
        if (getFileName() != null) o.setFileName(getFileName());
        if (getLineNumber() != null) o.setLineNumber(getLineNumber());
    }

    public void removeWhereEqualFromStackTrace_inner(StackTraceInnerDto o) {
    }
}