package io.github.jhannes.openapi.conversations.model;

import java.util.UUID;
import lombok.*;

@Data
public final class AddMessageToConversationDeltaDto implements DeltaDto {

    private String delta = "AddMessageToConversationDelta";
    private UUID conversationId;
    private UUID messageId;
    private ConversationMessageDto message = new ConversationMessageDto();

}