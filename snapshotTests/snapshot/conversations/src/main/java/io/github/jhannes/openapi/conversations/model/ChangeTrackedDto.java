package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import lombok.*;

@Data
public sealed class ChangeTrackedDto permits ConversationSnapshotDto {

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

}