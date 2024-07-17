package io.github.jhannes.openapi.websockets.model;

import lombok.*;

public sealed interface WebSocketRequestDto permits SubscribeDto {

    String getRequest();

    static Class<? extends WebSocketRequestDto> getType(String request) {
        return switch (request) {
            case "Subscribe" -> SubscribeDto.class;
            default -> throw new IllegalArgumentException("Illegal request " + request);
        };
    }

    static SubscribeDto createSubscribe() {
        return new SubscribeDto().setRequest("Subscribe");
    }
}