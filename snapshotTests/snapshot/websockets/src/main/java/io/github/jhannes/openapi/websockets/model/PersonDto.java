package io.github.jhannes.openapi.websockets.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public final class PersonDto extends RecipientDto {

    @Getter
    @RequiredArgsConstructor
    public enum GenderEnum {
        MALE("male"),
        FEMALE("female"),
        OTHER("other"),
        UNSPECIFIED("unspecified");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    private UUID id = null;
    private String type = null;
    private PersonNameDto name = null;
    private String phone = null;
    private LocalDate birthDate = null;
    private GenderEnum gender = null;

}