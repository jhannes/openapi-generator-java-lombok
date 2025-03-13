package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lombok.Data;

@Data
public final class ConversationMessageSnapshotDto implements ChangeTrackedInterface, ConversationMessageInterface {

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String text;
    private Set<String> tags = new HashSet<>();

    public boolean hasNoOptionalProperties() {
        return hasNoOptionalPropertiesForChangeTracked()
                && hasNoOptionalPropertiesForConversationMessage()
        ;
    }

    public ConversationMessageSnapshotDto putAll(ConversationMessageSnapshotDto o) {
        o.copyToConversationMessageSnapshot(this);
        return this;
    }

    @Override
    public ConversationMessageSnapshotDto putAll(ChangeTrackedInterface o) {
        o.copyToConversationMessageSnapshot(this);
        return this;
    }

    @Override
    public ConversationMessageSnapshotDto putAll(ConversationMessageInterface o) {
        o.copyToConversationMessageSnapshot(this);
        return this;
    }

    public ConversationMessageSnapshotDto removeWhereEqual(ConversationMessageSnapshotDto o) {
        o.removeWhereEqualFromConversationMessageSnapshot(this);
        return this;
    }

    @Override
    public ConversationMessageSnapshotDto removeWhereEqual(ChangeTrackedInterface o) {
        o.removeWhereEqualFromConversationMessageSnapshot(this);
        return this;
    }

    @Override
    public ConversationMessageSnapshotDto removeWhereEqual(ConversationMessageInterface o) {
        o.removeWhereEqualFromConversationMessageSnapshot(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCreatedAt() == null) fields.add(prefix + "createdAt");
        if (getUpdatedAt() == null) fields.add(prefix + "updatedAt");
        if (getText() == null) fields.add(prefix + "text");
        return fields;
    }

    @Override
    public void copyToConversationMessageSnapshot(ConversationMessageSnapshotDto o) {
        copyToChangeTrackedInterface(o);
        copyToConversationMessageInterface(o);
    }

    @Override
    public void removeWhereEqualFromConversationMessageSnapshot(ConversationMessageSnapshotDto o) {
        removeWhereEqualFromChangeTrackedInterface(o);
        removeWhereEqualFromConversationMessageInterface(o);
    }
}