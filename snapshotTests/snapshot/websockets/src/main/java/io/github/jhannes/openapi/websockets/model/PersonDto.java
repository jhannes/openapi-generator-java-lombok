package io.github.jhannes.openapi.websockets.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public final class PersonDto extends RecipientDto implements PersonInterface {

    private UUID id = null;
    private String type = null;
    private PersonNameDto name = null;
    private String phone = null;
    private LocalDate birthDate = null;
    private GenderEnum gender = null;

    @Override
    public PersonDto setEmail(String email) {
        super.setEmail(email);
        return this;
    }

}