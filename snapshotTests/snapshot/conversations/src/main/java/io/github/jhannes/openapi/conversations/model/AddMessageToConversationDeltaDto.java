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
        o.copyToAddMessageToConversationDelta(this);
        return this;
    }

    public AddMessageToConversationDeltaDto putAll(DeltaDto o) {
        o.copyToAddMessageToConversationDelta(this);
        return this;
    }

    public AddMessageToConversationDeltaDto removeWhereEqual(AddMessageToConversationDeltaDto o) {
        return this;
    }

    public AddMessageToConversationDeltaDto removeWhereEqual(DeltaDto o) {
        if (o instanceof AddMessageToConversationDeltaDto same) removeWhereEqual(same);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getDelta() == null) fields.add(prefix + "delta");
        if (getConversationId() == null) fields.add(prefix + "conversationId");
        if (getMessageId() == null) fields.add(prefix + "messageId");
        if (getMessage() != null) {
            fields.addAll(getMessage().missingRequiredFields(prefix + "message."));
        } else {
            fields.add(prefix + "message");
        }
        return fields;
    }

    public void copyToAddMessageToConversationDelta(AddMessageToConversationDeltaDto o) {
        if (getConversationId() != null) o.setConversationId(getConversationId());
        if (getMessageId() != null) o.setMessageId(getMessageId());
        if (getMessage() != null) o.setMessage(getMessage());
    }
}