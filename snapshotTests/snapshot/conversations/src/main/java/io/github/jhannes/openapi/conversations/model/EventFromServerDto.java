package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public final class EventFromServerDto extends CommandToServerDto implements MessageFromServerDto {

    private OffsetDateTime serverTime;
    private String username;

}