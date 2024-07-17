package io.github.jhannes.openapi.conversations.model;

import java.util.UUID;
import lombok.*;

@Data
public final class SubscribeRequestDto implements RequestToServerDto {

    private String request = "SubscribeRequest";
    private UUID clientId;

}