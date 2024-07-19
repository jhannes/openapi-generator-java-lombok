package io.github.jhannes.openapi.conversations.model;

import java.util.UUID;
import lombok.*;

@Data
public final class CreateConversationDeltaDto implements DeltaDto {

    private String delta = "CreateConversationDelta";
    private UUID conversationId;
    private ConversationInfoDto info = new ConversationInfoDto();

}