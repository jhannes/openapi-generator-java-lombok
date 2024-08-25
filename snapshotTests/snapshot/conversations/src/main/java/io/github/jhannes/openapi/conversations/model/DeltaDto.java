package io.github.jhannes.openapi.conversations.model;

import java.util.List;

public sealed interface DeltaDto permits AddMessageToConversationDeltaDto, CreateConversationDeltaDto, UpdateConversationDeltaDto {

    String getDelta();

    static Class<? extends DeltaDto> getType(String delta) {
        return switch (delta) {
            case "AddMessageToConversationDelta" -> AddMessageToConversationDeltaDto.class;
            case "UpdateConversationDelta" -> UpdateConversationDeltaDto.class;
            case "CreateConversationDelta" -> CreateConversationDeltaDto.class;
            default -> throw new IllegalArgumentException("Illegal delta " + delta);
        };
    }

    static AddMessageToConversationDeltaDto createAddMessageToConversationDelta() {
        return new AddMessageToConversationDeltaDto().setDelta("AddMessageToConversationDelta");
    }

    static UpdateConversationDeltaDto createUpdateConversationDelta() {
        return new UpdateConversationDeltaDto().setDelta("UpdateConversationDelta");
    }

    static CreateConversationDeltaDto createCreateConversationDelta() {
        return new CreateConversationDeltaDto().setDelta("CreateConversationDelta");
    }

    boolean isEmpty();
    List<String> missingRequiredFields(String prefix);
}