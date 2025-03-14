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
        if (o.getGivenName() != null) setGivenName(o.getGivenName());
        if (o.getFamilyName() != null) setFamilyName(o.getFamilyName());
        return this;
    }

    public PersonNameDto removeWhereEqual(PersonNameDto o) {
        if (Objects.equals(getGivenName(), o.getGivenName())) setGivenName(null);
        if (Objects.equals(getFamilyName(), o.getFamilyName())) setFamilyName(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

}