package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public final class CreateConversationDeltaDto implements DeltaDto {

    private String delta = "CreateConversationDelta";
    private UUID conversationId;
    private ConversationInfoDto info = new ConversationInfoDto();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public CreateConversationDeltaDto putAll(CreateConversationDeltaDto o) {
        o.copyToCreateConversationDelta(this);
        return this;
    }

    public CreateConversationDeltaDto putAll(DeltaDto o) {
        o.copyToCreateConversationDelta(this);
        return this;
    }

    public CreateConversationDeltaDto removeWhereEqual(CreateConversationDeltaDto o) {
        return this;
    }

    public CreateConversationDeltaDto removeWhereEqual(DeltaDto o) {
        if (o instanceof CreateConversationDeltaDto same) removeWhereEqual(same);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getDelta() == null) fields.add(prefix + "delta");
        if (getConversationId() == null) fields.add(prefix + "conversationId");
        if (getInfo() != null) {
            fields.addAll(getInfo().missingRequiredFields(prefix + "info."));
        } else {
            fields.add(prefix + "info");
        }
        return fields;
    }

    public void copyToCreateConversationDelta(CreateConversationDeltaDto o) {
        if (getConversationId() != null) o.setConversationId(getConversationId());
        if (getInfo() != null) o.setInfo(getInfo());
    }
}