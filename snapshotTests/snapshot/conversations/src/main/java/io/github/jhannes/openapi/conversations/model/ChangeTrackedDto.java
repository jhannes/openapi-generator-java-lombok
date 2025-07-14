package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public sealed class ChangeTrackedDto implements ChangeTrackedInterface permits ConversationSnapshotDto {

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public ChangeTrackedDto putAll(ChangeTrackedInterface o) {
        o.copyToChangeTracked(this);
        return this;
    }

    public ChangeTrackedDto removeWhereEqual(ChangeTrackedInterface o) {
        o.removeWhereEqualFromChangeTracked(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCreatedAt() == null) fields.add(prefix + "createdAt");
        if (getUpdatedAt() == null) fields.add(prefix + "updatedAt");
        return fields;
    }

    public void copyToChangeTracked(ChangeTrackedDto o) {
        copyToChangeTrackedInterface(o);
    }

    public void copyToConversationSnapshot(ConversationSnapshotDto o) {
        copyToChangeTracked(o);
    }
}