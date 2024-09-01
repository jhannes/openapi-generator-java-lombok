package io.github.jhannes.openapi.conversations.model;

import java.util.List;

public sealed interface MessageFromServerDto permits EventFromServerDto, SnapshotSetDto {


    boolean empty();
    List<String> missingRequiredFields(String prefix);
}