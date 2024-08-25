package io.github.jhannes.openapi.conversations.model;

import java.util.List;

public sealed interface MessageToServerDto permits CommandToServerDto, RequestToServerDto {


    boolean isEmpty();
    List<String> missingRequiredFields(String prefix);
}