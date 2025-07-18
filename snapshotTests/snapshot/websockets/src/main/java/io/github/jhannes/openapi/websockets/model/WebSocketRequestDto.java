package io.github.jhannes.openapi.websockets.model;

import java.util.List;

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

    WebSocketRequestDto putAll(WebSocketRequestDto o);
    WebSocketRequestDto removeWhereEqual(WebSocketRequestDto o);
    boolean hasNoOptionalProperties();
    List<String> missingRequiredFields(String prefix);

    default void copyToSubscribe(SubscribeDto o) {
    }
    default void removeWhereEqualFromSubscribe(SubscribeDto o) {
    }
}