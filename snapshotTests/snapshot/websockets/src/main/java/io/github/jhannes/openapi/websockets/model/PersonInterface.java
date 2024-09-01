package io.github.jhannes.openapi.websockets.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public sealed interface PersonInterface extends RecipientInterface permits PersonDto, PersonSnapshotDto {

    @Getter
    @RequiredArgsConstructor
    public enum GenderEnum {
        male("male"),
        female("female"),
        other("other"),
        unspecified("unspecified");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    UUID getId();
    /** <strong>read only</strong> */
    PersonInterface setId(UUID id);

    String getType();
    PersonInterface setType(String type);

    PersonNameDto getName();
    PersonInterface setName(PersonNameDto name);

    String getPhone();
    PersonInterface setPhone(String phone);

    LocalDate getBirthDate();
    PersonInterface setBirthDate(LocalDate birthDate);

    GenderEnum getGender();
    PersonInterface setGender(GenderEnum gender);

    boolean empty();
    PersonInterface putAll(PersonInterface o);
    PersonInterface removeWhereEqual(PersonInterface o);
    List<String> missingRequiredFields(String prefix);

    default void copyToPerson(PersonDto o) {
        copyToPersonInterface(o);
    }
    default void copyToPersonSnapshot(PersonSnapshotDto o) {
        copyToPersonInterface(o);
    }
    default void removeWhereEqualFromPerson(PersonDto o) {
        removeWhereEqualFromPersonInterface(o);
    }
    default void removeWhereEqualFromPersonSnapshot(PersonSnapshotDto o) {
        removeWhereEqualFromPersonInterface(o);
    }

    default boolean isPersonEmpty() {
        return isRecipientEmpty()
                && getId() == null
                && getType() == null
                && getName() == null
                && getPhone() == null
                && getBirthDate() == null
                && getGender() == null;
    }

    default void copyToPersonInterface(PersonInterface o) {
        copyToRecipientInterface(o);
        if (getId() != null) o.setId(getId());
        if (getType() != null) o.setType(getType());
        if (getName() != null) o.setName(getName());
        if (getPhone() != null) o.setPhone(getPhone());
        if (getBirthDate() != null) o.setBirthDate(getBirthDate());
        if (getGender() != null) o.setGender(getGender());
    }

    default void removeWhereEqualFromPersonInterface(PersonInterface o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getType(), o.getType())) o.setType(null);
        if (Objects.equals(getName(), o.getName())) o.setName(null);
        if (Objects.equals(getPhone(), o.getPhone())) o.setPhone(null);
        if (Objects.equals(getBirthDate(), o.getBirthDate())) o.setBirthDate(null);
        if (Objects.equals(getGender(), o.getGender())) o.setGender(null);
    }
}
