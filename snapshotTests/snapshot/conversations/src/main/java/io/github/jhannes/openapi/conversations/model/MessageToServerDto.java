package io.github.jhannes.openapi.conversations.model;

import java.util.List;

public sealed interface MessageToServerDto permits CommandToServerDto, RequestToServerDto {

    MessageToServerDto putAll(MessageToServerDto o);
    MessageToServerDto removeWhereEqual(MessageToServerDto o);
    boolean hasNoOptionalProperties();
    List<String> missingRequiredFields(String prefix);

    default void copyToCommandToServer(CommandToServerDto o) {
    }
    default void copyToEventFromServer(EventFromServerDto o) {
    }
    default void copyToSubscribeRequest(SubscribeRequestDto o) {
    }
    default void removeWhereEqualFromCommandToServer(CommandToServerDto o) {
    }
    default void removeWhereEqualFromEventFromServer(EventFromServerDto o) {
    }
    default void removeWhereEqualFromSubscribeRequest(SubscribeRequestDto o) {
    }
}