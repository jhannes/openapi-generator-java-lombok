package io.github.jhannes.openapi.fakerestapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class AuthorDto {

    private Integer id = null;
    private Integer idBook = null;
    private String firstName = null;
    private String lastName = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getIdBook() == null
                && getFirstName() == null
                && getLastName() == null
        ;
    }

    public AuthorDto putAll(AuthorDto o) {
        o.copyToAuthor(this);
        return this;
    }

    public AuthorDto removeWhereEqual(AuthorDto o) {
        o.removeWhereEqualFromAuthor(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToAuthor(AuthorDto o) {
        if (getId() != null) o.setId(getId());
        if (getIdBook() != null) o.setIdBook(getIdBook());
        if (getFirstName() != null) o.setFirstName(getFirstName());
        if (getLastName() != null) o.setLastName(getLastName());
    }

    public void removeWhereEqualFromAuthor(AuthorDto o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getIdBook(), o.getIdBook())) o.setIdBook(null);
        if (Objects.equals(getFirstName(), o.getFirstName())) o.setFirstName(null);
        if (Objects.equals(getLastName(), o.getLastName())) o.setLastName(null);
    }
}