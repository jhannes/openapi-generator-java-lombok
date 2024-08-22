package io.github.jhannes.openapi.websockets.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

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

}
