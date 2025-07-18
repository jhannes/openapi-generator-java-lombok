package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lombok.Data;

public sealed interface ConversationMessageInterface permits ConversationMessageDto, ConversationMessageSnapshotDto {

    String getText();
    ConversationMessageInterface setText(String text);

    Set<String> getTags();
    ConversationMessageInterface setTags(Set<String> tags);

    boolean hasNoOptionalProperties();
    ConversationMessageInterface putAll(ConversationMessageInterface o);
    ConversationMessageInterface removeWhereEqual(ConversationMessageInterface o);
    List<String> missingRequiredFields(String prefix);

    default void copyToConversationMessage(ConversationMessageInterface o) {
        copyToConversationMessageInterface(o);
    }
    default void copyToConversationMessageSnapshot(ConversationMessageSnapshotDto o) {
        copyToConversationMessageInterface(o);
    }
    default void removeWhereEqualFromConversationMessage(ConversationMessageInterface o) {
        removeWhereEqualFromConversationMessageInterface(o);
    }
    default void removeWhereEqualFromConversationMessageSnapshot(ConversationMessageSnapshotDto o) {
        removeWhereEqualFromConversationMessageInterface(o);
    }

    default boolean hasNoOptionalPropertiesForConversationMessage() {
        return getTags() == null;
    }

    default void copyToConversationMessageInterface(ConversationMessageInterface o) {
        if (getText() != null) o.setText(getText());
        if (getTags() != null) o.setTags(getTags());
    }

    default void removeWhereEqualFromConversationMessageInterface(ConversationMessageInterface o) {
        if (Objects.equals(getTags(), o.getTags())) o.setTags(null);
    }
}
