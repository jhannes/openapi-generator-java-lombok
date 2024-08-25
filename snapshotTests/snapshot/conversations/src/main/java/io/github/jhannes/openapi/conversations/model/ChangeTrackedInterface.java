package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public sealed interface ChangeTrackedInterface permits ChangeTrackedDto, ConversationMessageSnapshotDto {

    OffsetDateTime getCreatedAt();
    ChangeTrackedInterface setCreatedAt(OffsetDateTime createdAt);

    OffsetDateTime getUpdatedAt();
    ChangeTrackedInterface setUpdatedAt(OffsetDateTime updatedAt);

    boolean isEmpty();
    ChangeTrackedInterface putAll(ChangeTrackedInterface o);
    ChangeTrackedInterface removeWhereEqual(ChangeTrackedInterface o);
    List<String> missingRequiredFields(String prefix);

    default void copyToChangeTracked(ChangeTrackedDto o) {
        copyToChangeTrackedInterface(o);
    }
    default void copyToConversationMessageSnapshot(ConversationMessageSnapshotDto o) {
        copyToChangeTrackedInterface(o);
    }
    default void copyToConversationSnapshot(ConversationSnapshotDto o) {
        copyToChangeTrackedInterface(o);
    }
    default void removeWhereEqualFromChangeTracked(ChangeTrackedDto o) {
        removeWhereEqualFromChangeTrackedInterface(o);
    }
    default void removeWhereEqualFromConversationMessageSnapshot(ConversationMessageSnapshotDto o) {
        removeWhereEqualFromChangeTrackedInterface(o);
    }
    default void removeWhereEqualFromConversationSnapshot(ConversationSnapshotDto o) {
        removeWhereEqualFromChangeTrackedInterface(o);
    }

    default boolean isChangeTrackedEmpty() {
        return false;
    }

    default void copyToChangeTrackedInterface(ChangeTrackedInterface o) {
        if (getCreatedAt() != null) o.setCreatedAt(getCreatedAt());
        if (getUpdatedAt() != null) o.setUpdatedAt(getUpdatedAt());
    }

    default void removeWhereEqualFromChangeTrackedInterface(ChangeTrackedInterface o) {
    }
}
