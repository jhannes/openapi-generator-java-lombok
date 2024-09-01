package io.github.jhannes.openapi.fakerestapi.model;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class CoverPhotoDto {

    private Integer id = null;
    private Integer idBook = null;
    private URI url = null;

    public boolean empty() {
        return getId() == null
                && getIdBook() == null
                && getUrl() == null
        ;
    }

    public CoverPhotoDto putAll(CoverPhotoDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getIdBook() != null) setIdBook(o.getIdBook());
        if (o.getUrl() != null) setUrl(o.getUrl());
        return this;
    }

    public CoverPhotoDto removeWhereEqual(CoverPhotoDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getIdBook(), o.getIdBook())) setIdBook(null);
        if (Objects.equals(getUrl(), o.getUrl())) setUrl(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}