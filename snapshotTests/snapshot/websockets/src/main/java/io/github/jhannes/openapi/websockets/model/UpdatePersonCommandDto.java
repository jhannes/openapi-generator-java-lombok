package io.github.jhannes.openapi.websockets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public final class UpdatePersonCommandDto implements WebSocketCommandDto {

    private String command = "updatePerson";
    private UUID id;
    private PersonDto person = new PersonDto();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public UpdatePersonCommandDto putAll(UpdatePersonCommandDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getPerson() != null) setPerson(o.getPerson());
        return this;
    }

    public UpdatePersonCommandDto putAll(WebSocketMessageDto o) {
        if (o instanceof UpdatePersonCommandDto same) putAll(same);
        return this;
    }

    public UpdatePersonCommandDto removeWhereEqual(UpdatePersonCommandDto o) {
        return this;
    }

    public UpdatePersonCommandDto removeWhereEqual(WebSocketMessageDto o) {
        if (o instanceof UpdatePersonCommandDto same) removeWhereEqual(same);
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

}