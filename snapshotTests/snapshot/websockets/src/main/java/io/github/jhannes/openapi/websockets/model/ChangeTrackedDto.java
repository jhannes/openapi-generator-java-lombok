package io.github.jhannes.openapi.websockets.model;

import java.time.OffsetDateTime;
import lombok.*;

@Data
public sealed class ChangeTrackedDto permits StringSnapshotDto {

    private OffsetDateTime createdAt;
    private String createdBy;
    private OffsetDateTime updatedAt = null;
    private String updatedBy = null;

}