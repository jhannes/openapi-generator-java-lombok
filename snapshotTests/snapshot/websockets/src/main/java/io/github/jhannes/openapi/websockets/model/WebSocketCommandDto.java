package io.github.jhannes.openapi.websockets.model;

import lombok.*;

public sealed interface WebSocketCommandDto extends WebSocketMessageDto permits CreatePersonCommandDto, UpdatePersonCommandDto {

    String getCommand();

    static Class<? extends WebSocketCommandDto> getType(String command) {
        return switch (command) {
            case "createPerson" -> CreatePersonCommandDto.class;
            case "updatePerson" -> UpdatePersonCommandDto.class;
            default -> throw new IllegalArgumentException("Illegal command " + command);
        };
    }

    static CreatePersonCommandDto createcreatePerson() {
        return new CreatePersonCommandDto().setCommand("createPerson");
    }

    static UpdatePersonCommandDto createupdatePerson() {
        return new UpdatePersonCommandDto().setCommand("updatePerson");
    }
}