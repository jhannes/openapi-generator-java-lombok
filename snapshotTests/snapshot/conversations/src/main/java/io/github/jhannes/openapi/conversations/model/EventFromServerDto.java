package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;

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

}