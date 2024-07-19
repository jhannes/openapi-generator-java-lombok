package io.github.jhannes.openapi.websockets.model;

import java.util.UUID;
import lombok.*;

@Data
public final class CreatePersonCommandDto implements WebSocketCommandDto {

    private String command = "createPerson";
    private UUID id;
    private PersonDto person = new PersonDto();

}