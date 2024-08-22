package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import lombok.*;

public sealed interface ChangeTrackedInterface permits ChangeTrackedDto, ConversationMessageSnapshotDto {

    OffsetDateTime getCreatedAt();
    ChangeTrackedInterface setCreatedAt(OffsetDateTime createdAt);

    OffsetDateTime getUpdatedAt();
    ChangeTrackedInterface setUpdatedAt(OffsetDateTime updatedAt);

}
