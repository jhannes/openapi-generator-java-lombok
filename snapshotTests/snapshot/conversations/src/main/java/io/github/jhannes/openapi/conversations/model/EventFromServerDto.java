package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public final class EventFromServerDto extends CommandToServerDto implements MessageFromServerDto {

    private OffsetDateTime serverTime;
    private String username;

    @Override
    public EventFromServerDto setId(UUID id) {
        super.setId(id);
        return this;
    }

    @Override
    public EventFromServerDto setClientTime(OffsetDateTime clientTime) {
        super.setClientTime(clientTime);
        return this;
    }

    @Override
    public EventFromServerDto setDelta(DeltaDto delta) {
        super.setDelta(delta);
        return this;
    }

    public boolean hasNoOptionalProperties() {
        return super.hasNoOptionalProperties()
        ;
    }

    public EventFromServerDto putAll(CommandToServerDto o) {
        super.putAll(o);
        return this;
    }

    public EventFromServerDto putAll(EventFromServerDto o) {
        super.putAll(o);
        if (o.getServerTime() != null) setServerTime(o.getServerTime());
        if (o.getUsername() != null) setUsername(o.getUsername());
        return this;
    }

    public EventFromServerDto putAll(MessageFromServerDto o) {
        if (o instanceof CommandToServerDto base) putAll(base);
        return this;
    }

    public EventFromServerDto removeWhereEqual(EventFromServerDto o) {
        super.removeWhereEqual(o);
        return this;
    }

    public EventFromServerDto removeWhereEqual(MessageFromServerDto o) {
        if (o instanceof CommandToServerDto base) removeWhereEqual(base);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = super.missingRequiredFields(prefix);
        if (getServerTime() == null) fields.add(prefix + "serverTime");
        if (getUsername() == null) fields.add(prefix + "username");
        return fields;
    }

}