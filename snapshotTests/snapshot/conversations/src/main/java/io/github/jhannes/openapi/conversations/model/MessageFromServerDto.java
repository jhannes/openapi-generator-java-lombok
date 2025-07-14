package io.github.jhannes.openapi.conversations.model;

import java.util.List;

public sealed interface MessageFromServerDto permits EventFromServerDto, SnapshotSetDto {

    MessageFromServerDto putAll(MessageFromServerDto o);
    MessageFromServerDto removeWhereEqual(MessageFromServerDto o);
    boolean hasNoOptionalProperties();
    List<String> missingRequiredFields(String prefix);

    default void copyToEventFromServer(EventFromServerDto o) {
    }
    default void copyToSnapshotSet(SnapshotSetDto o) {
    }
}