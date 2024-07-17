package io.github.jhannes.openapi.serverHealth.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
public final class ExceptionDto {

    private String type;
    private String message = null;
    private List<StackTraceInnerDto> stackTrace = new ArrayList<>();

}