package io.github.jhannes.openapi.serverHealth.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

@Data
public final class StackTraceInnerDto {

    private String className;
    private String methodName;
    private String fileName;
    private BigDecimal lineNumber;

    public boolean isEmpty() {
        return false
        ;
    }

    public StackTraceInnerDto putAll(StackTraceInnerDto o) {
        if (o.getClassName() != null) setClassName(o.getClassName());
        if (o.getMethodName() != null) setMethodName(o.getMethodName());
        if (o.getFileName() != null) setFileName(o.getFileName());
        if (o.getLineNumber() != null) setLineNumber(o.getLineNumber());
        return this;
    }

    public StackTraceInnerDto removeWhereEqual(StackTraceInnerDto o) {
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

}