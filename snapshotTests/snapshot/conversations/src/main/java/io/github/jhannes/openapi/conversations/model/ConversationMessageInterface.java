package io.github.jhannes.openapi.conversations.model;

import java.util.LinkedHashSet;
import java.util.Set;
import lombok.*;

public sealed interface ConversationMessageInterface permits ConversationMessageDto, ConversationMessageSnapshotDto {

    String getText();
    ConversationMessageInterface setText(String text);

    Set<String> getTags();
    ConversationMessageInterface setTags(Set<String> tags);

}
