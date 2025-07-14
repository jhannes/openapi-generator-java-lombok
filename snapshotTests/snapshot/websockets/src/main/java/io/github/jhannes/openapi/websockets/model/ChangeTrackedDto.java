package io.github.jhannes.openapi.websockets.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public sealed class ChangeTrackedDto implements ChangeTrackedInterface permits StringSnapshotDto {

    private OffsetDateTime createdAt;
    private String createdBy;
    private OffsetDateTime updatedAt = null;
    private String updatedBy = null;

    public boolean hasNoOptionalProperties() {
        return getUpdatedAt() == null
                && getUpdatedBy() == null
                && hasNoOptionalPropertiesForChangeTracked()
        ;
    }

    public ChangeTrackedDto putAll(ChangeTrackedInterface o) {
        o.copyToChangeTracked(this);
        return this;
    }

    public ChangeTrackedDto removeWhereEqual(ChangeTrackedInterface o) {
        o.removeWhereEqualFromChangeTracked(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCreatedAt() == null) fields.add(prefix + "createdAt");
        if (getCreatedBy() == null) fields.add(prefix + "createdBy");
        return fields;
    }

    public void copyToChangeTracked(ChangeTrackedDto o) {
        copyToChangeTrackedInterface(o);
    }

    public void copyToStringSnapshot(StringSnapshotDto o) {
        copyToChangeTracked(o);
    }

    public void removeWhereEqualFromChangeTracked(ChangeTrackedDto o) {
        removeWhereEqualFromChangeTrackedInterface(o);
    }

    public void removeWhereEqualFromStringSnapshot(StringSnapshotDto o) {
        removeWhereEqualFromChangeTracked(o);
    }
}