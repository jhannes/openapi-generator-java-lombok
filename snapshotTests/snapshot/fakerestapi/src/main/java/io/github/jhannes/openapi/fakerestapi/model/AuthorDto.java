package io.github.jhannes.openapi.fakerestapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

@Data
public final class AuthorDto {

    private Integer id = null;
    private Integer idBook = null;
    private String firstName = null;
    private String lastName = null;

    public boolean isEmpty() {
        return getId() == null
                && getIdBook() == null
                && getFirstName() == null
                && getLastName() == null
        ;
    }

    public AuthorDto putAll(AuthorDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getIdBook() != null) setIdBook(o.getIdBook());
        if (o.getFirstName() != null) setFirstName(o.getFirstName());
        if (o.getLastName() != null) setLastName(o.getLastName());
        return this;
    }

    public AuthorDto removeWhereEqual(AuthorDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getIdBook(), o.getIdBook())) setIdBook(null);
        if (Objects.equals(getFirstName(), o.getFirstName())) setFirstName(null);
        if (Objects.equals(getLastName(), o.getLastName())) setLastName(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}