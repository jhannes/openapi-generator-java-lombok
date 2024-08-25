package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

public sealed interface RequestToServerDto extends MessageToServerDto permits SubscribeRequestDto {

    String getRequest();

    static Class<? extends RequestToServerDto> getType(String request) {
        return switch (request) {
            case "SubscribeRequest" -> SubscribeRequestDto.class;
            default -> throw new IllegalArgumentException("Illegal request " + request);
        };
    }

    static SubscribeRequestDto createSubscribeRequest() {
        return new SubscribeRequestDto().setRequest("SubscribeRequest");
    }
}