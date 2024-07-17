package io.github.jhannes.openapi.serverHealth.model;

import java.math.BigDecimal;
import lombok.*;

@Data
public final class StackTraceInnerDto {

    private String className;
    private String methodName;
    private String fileName;
    private BigDecimal lineNumber;

}