package io.github.jhannes.openapi.websockets.model;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    public boolean empty() {
        return super.empty()
                && getName() == null
                && getType() == null
        ;
    }

    public StringSnapshotDto putAll(StringSnapshotDto o) {
        o.copyToStringSnapshot(this);
        return this;
    }

    public StringSnapshotDto removeWhereEqual(StringSnapshotDto o) {
        o.removeWhereEqualFromStringSnapshot(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

    @Override
    public void copyToStringSnapshot(StringSnapshotDto o) {
        copyToChangeTracked(o);
        if (getName() != null) o.setName(getName());
        if (getType() != null) o.setType(getType());
    }

    @Override
    public void removeWhereEqualFromStringSnapshot(StringSnapshotDto o) {
        removeWhereEqualFromChangeTracked(o);
        if (Objects.equals(getName(), o.getName())) o.setName(null);
        if (Objects.equals(getType(), o.getType())) o.setType(null);
    }
}