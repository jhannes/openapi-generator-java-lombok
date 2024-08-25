package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

@Data
public sealed class ChangeTrackedDto implements ChangeTrackedInterface permits ConversationSnapshotDto {

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public boolean isEmpty() {
        return false;
    }

    @Override
    public ChangeTrackedDto putAll(ChangeTrackedInterface o) {
        o.copyToChangeTracked(this);
        return this;
    }

    @Override
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

}