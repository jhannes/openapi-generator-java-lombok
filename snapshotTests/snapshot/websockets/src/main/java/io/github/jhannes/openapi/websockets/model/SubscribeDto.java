package io.github.jhannes.openapi.websockets.model;

import lombok.*;

@Data
public final class SubscribeDto implements WebSocketRequestDto {

    private String request = "Subscribe";

}