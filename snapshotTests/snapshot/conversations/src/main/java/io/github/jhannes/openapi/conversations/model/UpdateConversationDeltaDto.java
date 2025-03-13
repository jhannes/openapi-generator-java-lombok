package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public final class UpdateConversationDeltaDto implements DeltaDto {

    private String delta = "UpdateConversationDelta";
    private UUID conversationId;
    private ConversationInfoDto info = new ConversationInfoDto();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public UpdateConversationDeltaDto putAll(UpdateConversationDeltaDto o) {
        if (o.getConversationId() != null) setConversationId(o.getConversationId());
        if (o.getInfo() != null) setInfo(o.getInfo());
        return this;
    }

    public UpdateConversationDeltaDto removeWhereEqual(UpdateConversationDeltaDto o) {
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

}