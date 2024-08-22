package io.github.jhannes.openapi.websockets.model;

import java.time.OffsetDateTime;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public final class StringSnapshotDto extends ChangeTrackedDto {

    private String name = null;
    private String type = null;

    @Override
    public StringSnapshotDto setCreatedAt(OffsetDateTime createdAt) {
        super.setCreatedAt(createdAt);
        return this;
    }

    @Override
    public StringSnapshotDto setCreatedBy(String createdBy) {
        super.setCreatedBy(createdBy);
        return this;
    }

    @Override
    public StringSnapshotDto setUpdatedAt(OffsetDateTime updatedAt) {
        super.setUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public StringSnapshotDto setUpdatedBy(String updatedBy) {
        super.setUpdatedBy(updatedBy);
        return this;
    }

}