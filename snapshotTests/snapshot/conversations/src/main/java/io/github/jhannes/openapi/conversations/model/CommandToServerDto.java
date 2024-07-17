package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;

@Data
public sealed class CommandToServerDto implements MessageToServerDto permits EventFromServerDto {

    private UUID id;
    private OffsetDateTime clientTime;
    private DeltaDto delta;

}