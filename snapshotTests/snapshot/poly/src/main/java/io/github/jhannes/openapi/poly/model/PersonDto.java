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
        o.copyToPerson(this);
        return this;
    }

    public PersonDto putAll(AnyPartyDto o) {
        o.copyToPerson(this);
        return this;
    }

    public PersonDto removeWhereEqual(PersonDto o) {
        o.removeWhereEqualFromPerson(this);
        return this;
    }

    public PersonDto removeWhereEqual(AnyPartyDto o) {
        o.removeWhereEqualFromPerson(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getGivenName() == null) fields.add(prefix + "givenName");
        if (getFamilyName() == null) fields.add(prefix + "familyName");
        return fields;
    }

    public void copyToPerson(PersonDto o) {
        if (getId() != null) o.setId(getId());
        if (getGivenName() != null) o.setGivenName(getGivenName());
        if (getFamilyName() != null) o.setFamilyName(getFamilyName());
        if (getEmail() != null) o.setEmail(getEmail());
        if (getPhone() != null) o.setPhone(getPhone());
        if (getBirthDate() != null) o.setBirthDate(getBirthDate());
    }

    public void removeWhereEqualFromPerson(PersonDto o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getEmail(), o.getEmail())) o.setEmail(null);
        if (Objects.equals(getPhone(), o.getPhone())) o.setPhone(null);
        if (Objects.equals(getBirthDate(), o.getBirthDate())) o.setBirthDate(null);
    }
}