package io.github.jhannes.openapi.websockets.model;

import lombok.*;

public sealed interface WebSocketCommandDto extends WebSocketMessageDto permits CreatePersonCommandDto, UpdatePersonCommandDto {

    static Class<? extends WebSocketCommandDto> getType(String command) {
        return switch (command) {
            case "createPerson" -> CreatePersonCommandDto.class;
            case "updatePerson" -> UpdatePersonCommandDto.class;
            default -> throw new IllegalArgumentException("Illegal command " + command);
        };
    }
}