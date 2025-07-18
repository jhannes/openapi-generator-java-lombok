package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public final class ConversationSnapshotDto extends ChangeTrackedDto {

    private UUID id;
    private ConversationInfoDto info = new ConversationInfoDto();
    private Map<String, ConversationMessageSnapshotDto> messages = new HashMap<>();

    @Override
    public ConversationSnapshotDto setCreatedAt(OffsetDateTime createdAt) {
        super.setCreatedAt(createdAt);
        return this;
    }

    @Override
    public ConversationSnapshotDto setUpdatedAt(OffsetDateTime updatedAt) {
        super.setUpdatedAt(updatedAt);
        return this;
    }

    public boolean hasNoOptionalProperties() {
        return super.hasNoOptionalProperties()
        ;
    }

    public ConversationSnapshotDto putAll(ConversationSnapshotDto o) {
        o.copyToConversationSnapshot(this);
        return this;
    }

    public ConversationSnapshotDto putAll(ChangeTrackedDto o) {
        o.copyToConversationSnapshot(this);
        return this;
    }

    public ConversationSnapshotDto removeWhereEqual(ConversationSnapshotDto o) {
        o.removeWhereEqualFromConversationSnapshot(this);
        return this;
    }

    public ConversationSnapshotDto removeWhereEqual(ChangeTrackedDto o) {
        o.removeWhereEqualFromConversationSnapshot(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = super.missingRequiredFields(prefix);
        if (getId() == null) fields.add(prefix + "id");
        if (getInfo() != null) {
            fields.addAll(getInfo().missingRequiredFields(prefix + "info."));
        } else {
            fields.add(prefix + "info");
        }
        if (getMessages() != null) {
            getMessages().forEach((key, value) -> fields.addAll(value.missingRequiredFields(prefix + "messages[" + key + "].")));
        } else {
            fields.add(prefix + "messages");
        }
        return fields;
    }

    public void copyToConversationSnapshot(ConversationSnapshotDto o) {
        copyToChangeTracked(o);
        if (getId() != null) o.setId(getId());
        if (getInfo() != null) o.setInfo(getInfo());
        if (getMessages() != null) o.setMessages(getMessages());
    }

    public void removeWhereEqualFromConversationSnapshot(ConversationSnapshotDto o) {
        removeWhereEqualFromChangeTracked(o);
    }
}