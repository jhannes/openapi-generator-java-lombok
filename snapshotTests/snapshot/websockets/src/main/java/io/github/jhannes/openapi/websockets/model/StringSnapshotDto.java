package io.github.jhannes.openapi.websockets.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public boolean isEmpty() {
        return super.isEmpty()
                && getName() == null
                && getType() == null
        ;
    }

    public StringSnapshotDto putAll(StringSnapshotDto o) {
        super.putAll(o);
        if (o.getName() != null) setName(o.getName());
        if (o.getType() != null) setType(o.getType());
        return this;
    }

    public StringSnapshotDto removeWhereEqual(StringSnapshotDto o) {
        super.removeWhereEqual(o);
        if (Objects.equals(getName(), o.getName())) setName(null);
        if (Objects.equals(getType(), o.getType())) setType(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}