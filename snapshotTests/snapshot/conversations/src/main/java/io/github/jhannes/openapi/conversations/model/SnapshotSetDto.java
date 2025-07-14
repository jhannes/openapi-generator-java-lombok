package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class SnapshotSetDto implements MessageFromServerDto {

    private List<ConversationSnapshotDto> conversations = new ArrayList<>();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public SnapshotSetDto putAll(SnapshotSetDto o) {
        o.copyToSnapshotSet(this);
        return this;
    }

    public SnapshotSetDto putAll(MessageFromServerDto o) {
        o.copyToSnapshotSet(this);
        return this;
    }

    public SnapshotSetDto removeWhereEqual(SnapshotSetDto o) {
        return this;
    }

    public SnapshotSetDto removeWhereEqual(MessageFromServerDto o) {
        if (o instanceof SnapshotSetDto same) removeWhereEqual(same);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getConversations() != null) {
            for (int i = 0; i < getConversations().size(); i++) {
                fields.addAll(getConversations().get(i).missingRequiredFields(prefix + "conversations[" + i + "]."));
            }
        } else {
            fields.add(prefix + "conversations");
        }
        return fields;
    }

    public void copyToSnapshotSet(SnapshotSetDto o) {
        if (getConversations() != null) o.setConversations(getConversations());
    }
}