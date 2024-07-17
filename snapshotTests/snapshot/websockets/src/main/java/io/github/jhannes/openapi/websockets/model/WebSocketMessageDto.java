package io.github.jhannes.openapi.websockets.model;

import lombok.*;

public sealed interface WebSocketMessageDto permits WebSocketCommandDto {

    String getCommand();

    static Class<? extends WebSocketMessageDto> getType(String command) {
        return switch (command) {
            case "updatePerson" -> UpdatePersonCommandDto.class;
            case "createPerson" -> CreatePersonCommandDto.class;
            default -> throw new IllegalArgumentException("Illegal command " + command);
        };
    }

    static UpdatePersonCommandDto createupdatePerson() {
        return new UpdatePersonCommandDto().setCommand("updatePerson");
    }

    static CreatePersonCommandDto createcreatePerson() {
        return new CreatePersonCommandDto().setCommand("createPerson");
    }
}