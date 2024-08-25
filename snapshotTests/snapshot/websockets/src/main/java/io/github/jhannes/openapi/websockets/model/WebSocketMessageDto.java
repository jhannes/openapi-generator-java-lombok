package io.github.jhannes.openapi.websockets.model;

import java.util.List;

public sealed interface WebSocketMessageDto permits WebSocketCommandDto {

    String getCommand();

    static Class<? extends WebSocketMessageDto> getType(String command) {
        return switch (command) {
            case "updatePerson" -> UpdatePersonCommandDto.class;
            case "createPerson" -> CreatePersonCommandDto.class;
            default -> throw new IllegalArgumentException("Illegal command " + command);
        };
    }

    static UpdatePersonCommandDto createUpdatePerson() {
        return new UpdatePersonCommandDto().setCommand("updatePerson");
    }

    static CreatePersonCommandDto createCreatePerson() {
        return new CreatePersonCommandDto().setCommand("createPerson");
    }

    boolean isEmpty();
    List<String> missingRequiredFields(String prefix);
}