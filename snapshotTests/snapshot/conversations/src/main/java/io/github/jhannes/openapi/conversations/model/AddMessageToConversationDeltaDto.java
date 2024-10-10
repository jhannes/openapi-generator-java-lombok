package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public final class AddMessageToConversationDeltaDto implements DeltaDto {

    private String delta = "AddMessageToConversationDelta";
    private UUID conversationId;
    private UUID messageId;
    private ConversationMessageDto message = new ConversationMessageDto();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public AddMessageToConversationDeltaDto putAll(AddMessageToConversationDeltaDto o) {
        if (o.getDelta() != null) setDelta(o.getDelta());
        if (o.getConversationId() != null) setConversationId(o.getConversationId());
        if (o.getMessageId() != null) setMessageId(o.getMessageId());
        if (o.getMessage() != null) setMessage(o.getMessage());
        return this;
    }

    public AddMessageToConversationDeltaDto removeWhereEqual(AddMessageToConversationDeltaDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getDelta() == null) fields.add(prefix + "delta");
        if (getConversationId() == null) fields.add(prefix + "conversationId");
        if (getMessageId() == null) fields.add(prefix + "messageId");
        if (getMessage() == null) fields.add(prefix + "message");
        return fields;
    }

}