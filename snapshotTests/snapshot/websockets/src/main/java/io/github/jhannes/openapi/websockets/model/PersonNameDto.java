package io.github.jhannes.openapi.websockets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class PersonNameDto {

    private String givenName = null;
    private String familyName = null;

    public boolean hasNoOptionalProperties() {
        return getGivenName() == null
                && getFamilyName() == null
        ;
    }

    public PersonNameDto putAll(PersonNameDto o) {
        o.copyToPersonName(this);
        return this;
    }

    public PersonNameDto removeWhereEqual(PersonNameDto o) {
        o.removeWhereEqualFromPersonName(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToPersonName(PersonNameDto o) {
        if (getGivenName() != null) o.setGivenName(getGivenName());
        if (getFamilyName() != null) o.setFamilyName(getFamilyName());
    }

    public void removeWhereEqualFromPersonName(PersonNameDto o) {
        if (Objects.equals(getGivenName(), o.getGivenName())) o.setGivenName(null);
        if (Objects.equals(getFamilyName(), o.getFamilyName())) o.setFamilyName(null);
    }
}