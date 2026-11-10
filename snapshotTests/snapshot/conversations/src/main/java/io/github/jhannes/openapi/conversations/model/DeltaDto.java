package io.github.jhannes.openapi.conversations.model;

import java.util.List;

public sealed interface DeltaDto permits AddMessageToConversationDeltaDto, CreateConversationDeltaDto, UpdateConversationDeltaDto {

    String getDelta();

    static Class<? extends DeltaDto> getType(String delta) {
        return switch (delta) {
            case "AddMessageToConversationDelta" -> AddMessageToConversationDeltaDto.class;
            case "CreateConversationDelta" -> CreateConversationDeltaDto.class;
            case "UpdateConversationDelta" -> UpdateConversationDeltaDto.class;
            default -> throw new IllegalArgumentException("Illegal delta " + delta);
        };
    }

    static AddMessageToConversationDeltaDto createAddMessageToConversationDelta() {
        return new AddMessageToConversationDeltaDto().setDelta("AddMessageToConversationDelta");
    }

    static CreateConversationDeltaDto createCreateConversationDelta() {
        return new CreateConversationDeltaDto().setDelta("CreateConversationDelta");
    }

    static UpdateConversationDeltaDto createUpdateConversationDelta() {
        return new UpdateConversationDeltaDto().setDelta("UpdateConversationDelta");
    }

    DeltaDto putAll(DeltaDto o);
    DeltaDto removeWhereEqual(DeltaDto o);
    boolean hasNoOptionalProperties();
    List<String> missingRequiredFields(String prefix);

    default void copyToAddMessageToConversationDelta(AddMessageToConversationDeltaDto o) {
    }
    default void copyToCreateConversationDelta(CreateConversationDeltaDto o) {
    }
    default void copyToUpdateConversationDelta(UpdateConversationDeltaDto o) {
    }
    default void removeWhereEqualFromAddMessageToConversationDelta(AddMessageToConversationDeltaDto o) {
    }
    default void removeWhereEqualFromCreateConversationDelta(CreateConversationDeltaDto o) {
    }
    default void removeWhereEqualFromUpdateConversationDelta(UpdateConversationDeltaDto o) {
    }
}