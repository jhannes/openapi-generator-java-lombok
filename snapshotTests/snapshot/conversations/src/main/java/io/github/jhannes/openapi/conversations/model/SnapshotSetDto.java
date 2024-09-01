package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class SnapshotSetDto implements MessageFromServerDto {

    private List<ConversationSnapshotDto> conversations = new ArrayList<>();

    public boolean empty() {
        return true;
    }

    public SnapshotSetDto putAll(SnapshotSetDto o) {
        if (o.getConversations() != null) setConversations(o.getConversations());
        return this;
    }

    public SnapshotSetDto removeWhereEqual(SnapshotSetDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getConversations() == null) fields.add(prefix + "conversations");
        return fields;
    }

}