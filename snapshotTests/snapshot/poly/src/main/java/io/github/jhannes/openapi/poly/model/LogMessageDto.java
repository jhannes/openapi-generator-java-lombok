package io.github.jhannes.openapi.poly.model;

import lombok.*;

@Data
public final class LogMessageDto {

    private String message;
    private Object error = null;

}