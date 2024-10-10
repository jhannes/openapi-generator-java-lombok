package io.github.jhannes.openapi.websockets.model;

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

    @Override
    public RecipientDto putAll(RecipientInterface o) {
        o.copyToRecipient(this);
        return this;
    }

    @Override
    public RecipientDto removeWhereEqual(RecipientInterface o) {
        o.removeWhereEqualFromRecipient(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}