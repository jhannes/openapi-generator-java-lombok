package io.github.jhannes.openapi.websockets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public final class CreatePersonCommandDto implements WebSocketCommandDto {

    private String command = "createPerson";
    private UUID id;
    private PersonDto person = new PersonDto();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public CreatePersonCommandDto putAll(CreatePersonCommandDto o) {
        o.copyToCreatePersonCommand(this);
        return this;
    }

    public CreatePersonCommandDto putAll(WebSocketMessageDto o) {
        o.copyToCreatePersonCommand(this);
        return this;
    }

    public CreatePersonCommandDto removeWhereEqual(CreatePersonCommandDto o) {
        return this;
    }

    public CreatePersonCommandDto removeWhereEqual(WebSocketMessageDto o) {
        if (o instanceof CreatePersonCommandDto same) removeWhereEqual(same);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCommand() == null) fields.add(prefix + "command");
        if (getId() == null) fields.add(prefix + "id");
        if (getPerson() != null) {
            fields.addAll(getPerson().missingRequiredFields(prefix + "person."));
        } else {
            fields.add(prefix + "person");
        }
        return fields;
    }

    public void copyToCreatePersonCommand(CreatePersonCommandDto o) {
        if (getId() != null) o.setId(getId());
        if (getPerson() != null) o.setPerson(getPerson());
    }
}