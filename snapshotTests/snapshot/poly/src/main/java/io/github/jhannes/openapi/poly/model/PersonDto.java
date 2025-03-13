package io.github.jhannes.openapi.poly.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.Data;

@Data
public final class PersonDto implements AnyPartyDto {

    private UUID id = null;
    private String type;
    private String givenName;
    private String familyName;
    private String email = null;
    private String phone = null;
    private LocalDate birthDate = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getEmail() == null
                && getPhone() == null
                && getBirthDate() == null
        ;
    }

    public PersonDto putAll(PersonDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getGivenName() != null) setGivenName(o.getGivenName());
        if (o.getFamilyName() != null) setFamilyName(o.getFamilyName());
        if (o.getEmail() != null) setEmail(o.getEmail());
        if (o.getPhone() != null) setPhone(o.getPhone());
        if (o.getBirthDate() != null) setBirthDate(o.getBirthDate());
        return this;
    }

    public PersonDto removeWhereEqual(PersonDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getEmail(), o.getEmail())) setEmail(null);
        if (Objects.equals(getPhone(), o.getPhone())) setPhone(null);
        if (Objects.equals(getBirthDate(), o.getBirthDate())) setBirthDate(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getGivenName() == null) fields.add(prefix + "givenName");
        if (getFamilyName() == null) fields.add(prefix + "familyName");
        return fields;
    }

}