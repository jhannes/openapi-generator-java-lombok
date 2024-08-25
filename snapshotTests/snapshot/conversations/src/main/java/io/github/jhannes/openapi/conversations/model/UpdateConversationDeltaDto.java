package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.*;

@Data
public final class UpdateConversationDeltaDto implements DeltaDto {

    private String delta = "UpdateConversationDelta";
    private UUID conversationId;
    private ConversationInfoDto info = new ConversationInfoDto();

    public boolean isEmpty() {
        return false
        ;
    }

    public UpdateConversationDeltaDto putAll(UpdateConversationDeltaDto o) {
        if (o.getDelta() != null) setDelta(o.getDelta());
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
        if (getInfo() == null) fields.add(prefix + "info");
        return fields;
    }

}