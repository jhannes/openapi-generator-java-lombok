package io.github.jhannes.openapi.websockets.model;

import java.util.List;
import java.util.Objects;
import lombok.Data;

public sealed interface RecipientInterface permits PersonInterface, RecipientDto {

    String getEmail();
    RecipientInterface setEmail(String email);

    boolean hasNoOptionalProperties();
    RecipientInterface putAll(RecipientInterface o);
    RecipientInterface removeWhereEqual(RecipientInterface o);
    List<String> missingRequiredFields(String prefix);

    default void copyToPerson(PersonInterface o) {
        copyToRecipientInterface(o);
    }
    default void copyToPersonSnapshot(PersonSnapshotDto o) {
        copyToRecipientInterface(o);
    }
    default void copyToRecipient(RecipientDto o) {
        copyToRecipientInterface(o);
    }
    default void removeWhereEqualFromPerson(PersonInterface o) {
        removeWhereEqualFromRecipientInterface(o);
    }
    default void removeWhereEqualFromPersonSnapshot(PersonSnapshotDto o) {
        removeWhereEqualFromRecipientInterface(o);
    }
    default void removeWhereEqualFromRecipient(RecipientDto o) {
        removeWhereEqualFromRecipientInterface(o);
    }

    default boolean hasNoOptionalPropertiesForRecipient() {
        return getEmail() == null;
    }

    default void copyToRecipientInterface(RecipientInterface o) {
        if (getEmail() != null) o.setEmail(getEmail());
    }

    default void removeWhereEqualFromRecipientInterface(RecipientInterface o) {
        if (Objects.equals(getEmail(), o.getEmail())) o.setEmail(null);
    }
}
