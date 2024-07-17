package io.github.jhannes.openapi.conversations.model;

import lombok.*;

public sealed interface RequestToServerDto extends MessageToServerDto permits SubscribeRequestDto {

    static Class<? extends RequestToServerDto> getType(String request) {
        return switch (request) {
            case "SubscribeRequest" -> SubscribeRequestDto.class;
            default -> throw new IllegalArgumentException("Illegal request " + request);
        };
    }
}