package io.github.jhannes.openapi.websockets.model;

import java.util.List;

public sealed interface WebSocketMessageDto permits SubscribeDto, WebSocketCommandDto {

    String getCommand();

    static Class<? extends WebSocketMessageDto> getType(String command) {
        return switch (command) {
            case "updatePerson" -> UpdatePersonCommandDto.class;
            case "createPerson" -> CreatePersonCommandDto.class;
            case "Subscribe" -> SubscribeDto.class;
            default -> throw new IllegalArgumentException("Illegal command " + command);
        };
    }

    static UpdatePersonCommandDto createUpdatePerson() {
        return new UpdatePersonCommandDto().setCommand("updatePerson");
    }

    static CreatePersonCommandDto createCreatePerson() {
        return new CreatePersonCommandDto().setCommand("createPerson");
    }

    static SubscribeDto createSubscribe() {
        return new SubscribeDto().setCommand("Subscribe");
    }

    WebSocketMessageDto putAll(WebSocketMessageDto o);
    WebSocketMessageDto removeWhereEqual(WebSocketMessageDto o);
    boolean hasNoOptionalProperties();
    List<String> missingRequiredFields(String prefix);

    default void copyToCreatePersonCommand(CreatePersonCommandDto o) {
    }
    default void copyToSubscribe(SubscribeDto o) {
    }
    default void copyToUpdatePersonCommand(UpdatePersonCommandDto o) {
    }
    default void removeWhereEqualFromCreatePersonCommand(CreatePersonCommandDto o) {
    }
    default void removeWhereEqualFromSubscribe(SubscribeDto o) {
    }
    default void removeWhereEqualFromUpdatePersonCommand(UpdatePersonCommandDto o) {
    }
}