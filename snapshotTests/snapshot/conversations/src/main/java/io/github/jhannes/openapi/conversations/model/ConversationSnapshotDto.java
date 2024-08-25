package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import lombok.*;

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

    public boolean isEmpty() {
        return super.isEmpty()
        ;
    }

    public ConversationSnapshotDto putAll(ConversationSnapshotDto o) {
        super.putAll(o);
        if (o.getId() != null) setId(o.getId());
        if (o.getInfo() != null) setInfo(o.getInfo());
        if (o.getMessages() != null) setMessages(o.getMessages());
        return this;
    }

    public ConversationSnapshotDto removeWhereEqual(ConversationSnapshotDto o) {
        super.removeWhereEqual(o);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = super.missingRequiredFields(prefix);
        if (getId() == null) fields.add(prefix + "id");
        if (getInfo() == null) fields.add(prefix + "info");
        if (getMessages() == null) fields.add(prefix + "messages");
        return fields;
    }

}