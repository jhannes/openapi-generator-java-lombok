package io.github.jhannes.openapi.websockets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.*;

@Data
public final class CreatePersonCommandDto implements WebSocketCommandDto {

    private String command = "createPerson";
    private UUID id;
    private PersonDto person = new PersonDto();

    public boolean isEmpty() {
        return false
        ;
    }

    public CreatePersonCommandDto putAll(CreatePersonCommandDto o) {
        if (o.getCommand() != null) setCommand(o.getCommand());
        if (o.getId() != null) setId(o.getId());
        if (o.getPerson() != null) setPerson(o.getPerson());
        return this;
    }

    public CreatePersonCommandDto removeWhereEqual(CreatePersonCommandDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCommand() == null) fields.add(prefix + "command");
        if (getId() == null) fields.add(prefix + "id");
        if (getPerson() == null) fields.add(prefix + "person");
        return fields;
    }

}