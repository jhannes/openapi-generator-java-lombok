package io.github.jhannes.openapi.websockets.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

public sealed interface ChangeTrackedInterface permits ChangeTrackedDto, PersonSnapshotDto {

    OffsetDateTime getCreatedAt();
    ChangeTrackedInterface setCreatedAt(OffsetDateTime createdAt);

    String getCreatedBy();
    ChangeTrackedInterface setCreatedBy(String createdBy);

    OffsetDateTime getUpdatedAt();
    ChangeTrackedInterface setUpdatedAt(OffsetDateTime updatedAt);

    String getUpdatedBy();
    ChangeTrackedInterface setUpdatedBy(String updatedBy);

    boolean empty();
    ChangeTrackedInterface putAll(ChangeTrackedInterface o);
    ChangeTrackedInterface removeWhereEqual(ChangeTrackedInterface o);
    List<String> missingRequiredFields(String prefix);

    default void copyToChangeTracked(ChangeTrackedDto o) {
        copyToChangeTrackedInterface(o);
    }
    default void copyToPersonSnapshot(PersonSnapshotDto o) {
        copyToChangeTrackedInterface(o);
    }
    default void copyToStringSnapshot(StringSnapshotDto o) {
        copyToChangeTrackedInterface(o);
    }
    default void removeWhereEqualFromChangeTracked(ChangeTrackedDto o) {
        removeWhereEqualFromChangeTrackedInterface(o);
    }
    default void removeWhereEqualFromPersonSnapshot(PersonSnapshotDto o) {
        removeWhereEqualFromChangeTrackedInterface(o);
    }
    default void removeWhereEqualFromStringSnapshot(StringSnapshotDto o) {
        removeWhereEqualFromChangeTrackedInterface(o);
    }

    default boolean isChangeTrackedEmpty() {
        return getUpdatedAt() == null
                && getUpdatedBy() == null;
    }

    default void copyToChangeTrackedInterface(ChangeTrackedInterface o) {
        if (getCreatedAt() != null) o.setCreatedAt(getCreatedAt());
        if (getCreatedBy() != null) o.setCreatedBy(getCreatedBy());
        if (getUpdatedAt() != null) o.setUpdatedAt(getUpdatedAt());
        if (getUpdatedBy() != null) o.setUpdatedBy(getUpdatedBy());
    }

    default void removeWhereEqualFromChangeTrackedInterface(ChangeTrackedInterface o) {
        if (Objects.equals(getUpdatedAt(), o.getUpdatedAt())) o.setUpdatedAt(null);
        if (Objects.equals(getUpdatedBy(), o.getUpdatedBy())) o.setUpdatedBy(null);
    }
}
