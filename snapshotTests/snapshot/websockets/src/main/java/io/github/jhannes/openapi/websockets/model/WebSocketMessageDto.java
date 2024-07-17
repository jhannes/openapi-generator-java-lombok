package io.github.jhannes.openapi.websockets.model;

import lombok.*;

public sealed interface WebSocketMessageDto permits WebSocketCommandDto {

    static Class<? extends WebSocketMessageDto> getType(String command) {
        return switch (command) {
            case "updatePerson" -> UpdatePersonCommandDto.class;
            case "createPerson" -> CreatePersonCommandDto.class;
            default -> throw new IllegalArgumentException("Illegal command " + command);
        };
    }
}