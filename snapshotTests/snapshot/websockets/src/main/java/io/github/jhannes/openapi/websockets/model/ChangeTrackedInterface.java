package io.github.jhannes.openapi.websockets.model;

import java.time.OffsetDateTime;
import lombok.*;

public sealed interface ChangeTrackedInterface permits ChangeTrackedDto, PersonSnapshotDto {

    OffsetDateTime getCreatedAt();
    ChangeTrackedInterface setCreatedAt(OffsetDateTime createdAt);

    String getCreatedBy();
    ChangeTrackedInterface setCreatedBy(String createdBy);

    OffsetDateTime getUpdatedAt();
    ChangeTrackedInterface setUpdatedAt(OffsetDateTime updatedAt);

    String getUpdatedBy();
    ChangeTrackedInterface setUpdatedBy(String updatedBy);

}
