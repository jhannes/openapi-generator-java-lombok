package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import lombok.*;

@Data
public sealed class ChangeTrackedDto implements ChangeTrackedInterface permits ConversationSnapshotDto {

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

}