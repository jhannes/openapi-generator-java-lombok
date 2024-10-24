package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public sealed class CommandToServerDto implements MessageToServerDto permits EventFromServerDto {

    private UUID id;
    private OffsetDateTime clientTime;
    private DeltaDto delta;

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public CommandToServerDto putAll(CommandToServerDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getClientTime() != null) setClientTime(o.getClientTime());
        if (o.getDelta() != null) setDelta(o.getDelta());
        return this;
    }

    public CommandToServerDto removeWhereEqual(CommandToServerDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getId() == null) fields.add(prefix + "id");
        if (getClientTime() == null) fields.add(prefix + "clientTime");
        if (getDelta() != null) {
            fields.addAll(getDelta().missingRequiredFields(prefix + "delta."));
        } else {
            fields.add(prefix + "delta");
        }
        return fields;
    }

}