package io.github.jhannes.openapi.conversations.model;

import java.util.LinkedHashSet;
import java.util.Set;
import lombok.*;

@Data
public final class ConversationMessageDto {

    private String text;
    private Set<String> tags = new LinkedHashSet<>();

}