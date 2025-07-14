package io.github.jhannes.openapi.websockets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public sealed class RecipientDto implements RecipientInterface permits PersonDto {

    private String email = null;

    public boolean hasNoOptionalProperties() {
        return getEmail() == null
                && hasNoOptionalPropertiesForRecipient()
        ;
    }

    public RecipientDto putAll(RecipientInterface o) {
        o.copyToRecipient(this);
        return this;
    }

    public RecipientDto removeWhereEqual(RecipientInterface o) {
        o.removeWhereEqualFromRecipient(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToRecipient(RecipientDto o) {
        copyToRecipientInterface(o);
    }

    public void copyToPerson(PersonDto o) {
        copyToRecipient(o);
    }

    public void removeWhereEqualFromRecipient(RecipientDto o) {
        removeWhereEqualFromRecipientInterface(o);
    }

    public void removeWhereEqualFromPerson(PersonDto o) {
        removeWhereEqualFromRecipient(o);
    }
}