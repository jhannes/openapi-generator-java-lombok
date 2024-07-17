package io.github.jhannes.openapi.websockets.model;

import java.util.UUID;
import lombok.*;

@Data
public final class UpdatePersonCommandDto implements WebSocketCommandDto {

    private String command = "updatePerson";
    private UUID id;
    private PersonDto person;

}