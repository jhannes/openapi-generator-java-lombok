package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public final class ConversationSnapshotDto extends ChangeTrackedDto {

    private UUID id;
    private ConversationInfoDto info;
    private Map<String, ConversationMessageSnapshotDto> messages = new HashMap<>();

}