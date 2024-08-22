package io.github.jhannes.openapi.conversations.model;

import java.time.OffsetDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.*;

@Data
public final class ConversationMessageSnapshotDto implements ChangeTrackedInterface, ConversationMessageInterface {

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String text;
    private Set<String> tags = new LinkedHashSet<>();

}