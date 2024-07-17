package io.github.jhannes.openapi.conversations.model;

import lombok.*;

@Data
public final class ConversationInfoDto {

    private String title;
    private String summary = null;

}