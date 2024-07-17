package io.github.jhannes.openapi.websockets.model;

import lombok.*;

public sealed interface WebSocketRequestDto permits SubscribeDto {

    static Class<? extends WebSocketRequestDto> getType(String request) {
        return switch (request) {
            case "Subscribe" -> SubscribeDto.class;
            default -> throw new IllegalArgumentException("Illegal request " + request);
        };
    }
}