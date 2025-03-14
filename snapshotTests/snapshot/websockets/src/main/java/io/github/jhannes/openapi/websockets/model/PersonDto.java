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

    public boolean hasNoOptionalProperties() {
        return super.hasNoOptionalProperties()
                && hasNoOptionalPropertiesForPerson()
        ;
    }

    @Override
    public PersonDto putAll(PersonInterface o) {
        o.copyToPerson(this);
        return this;
    }

    @Override
    public PersonDto removeWhereEqual(PersonInterface o) {
        o.removeWhereEqualFromPerson(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

}