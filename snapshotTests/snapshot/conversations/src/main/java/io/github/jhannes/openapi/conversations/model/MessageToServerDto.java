package io.github.jhannes.openapi.conversations.model;

import java.util.List;

public sealed interface MessageToServerDto permits CommandToServerDto, RequestToServerDto {

    MessageToServerDto putAll(MessageToServerDto o);
    MessageToServerDto removeWhereEqual(MessageToServerDto o);
    boolean hasNoOptionalProperties();
    List<String> missingRequiredFields(String prefix);
}