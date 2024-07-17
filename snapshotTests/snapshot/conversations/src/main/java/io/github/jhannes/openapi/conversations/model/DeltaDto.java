package io.github.jhannes.openapi.conversations.model;

import lombok.*;

public sealed interface DeltaDto permits AddMessageToConversationDeltaDto, CreateConversationDeltaDto, UpdateConversationDeltaDto {

    static Class<? extends DeltaDto> getType(String delta) {
        return switch (delta) {
            case "AddMessageToConversationDelta" -> AddMessageToConversationDeltaDto.class;
            case "UpdateConversationDelta" -> UpdateConversationDeltaDto.class;
            case "CreateConversationDelta" -> CreateConversationDeltaDto.class;
            default -> throw new IllegalArgumentException("Illegal delta " + delta);
        };
    }
}