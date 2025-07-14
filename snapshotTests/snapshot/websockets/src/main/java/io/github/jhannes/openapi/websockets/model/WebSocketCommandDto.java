package io.github.jhannes.openapi.websockets.model;

import java.util.ArrayList;
import java.util.List;

public sealed interface WebSocketCommandDto extends WebSocketMessageDto permits CreatePersonCommandDto, UpdatePersonCommandDto {

    String getCommand();

    static Class<? extends WebSocketCommandDto> getType(String command) {
        return switch (command) {
            case "createPerson" -> CreatePersonCommandDto.class;
            case "updatePerson" -> UpdatePersonCommandDto.class;
            default -> throw new IllegalArgumentException("Illegal command " + command);
        };
    }

    static CreatePersonCommandDto createCreatePerson() {
        return new CreatePersonCommandDto().setCommand("createPerson");
    }

    static UpdatePersonCommandDto createUpdatePerson() {
        return new UpdatePersonCommandDto().setCommand("updatePerson");
    }

    default void copyToCreatePersonCommand(CreatePersonCommandDto o) {
    }
    default void copyToUpdatePersonCommand(UpdatePersonCommandDto o) {
    }
}