package io.github.jhannes.openapi.conversations.model;

import java.util.UUID;
import lombok.*;

@Data
public final class UpdateConversationDeltaDto implements DeltaDto {

    private String delta = "UpdateConversationDelta";
    private UUID conversationId;
    private ConversationInfoDto info;

}