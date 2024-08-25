package io.github.jhannes.openapi.conversations.model;

import java.util.List;

public sealed interface MessageFromServerDto permits EventFromServerDto, SnapshotSetDto {


    boolean isEmpty();
    List<String> missingRequiredFields(String prefix);
}