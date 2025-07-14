package io.github.jhannes.openapi.fakerestapi.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class CoverPhotoDto {

    private Integer id = null;
    private Integer idBook = null;
    private URI url = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getIdBook() == null
                && getUrl() == null
        ;
    }

    public CoverPhotoDto putAll(CoverPhotoDto o) {
        o.copyToCoverPhoto(this);
        return this;
    }

    public CoverPhotoDto removeWhereEqual(CoverPhotoDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getIdBook(), o.getIdBook())) setIdBook(null);
        if (Objects.equals(getUrl(), o.getUrl())) setUrl(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToCoverPhoto(CoverPhotoDto o) {
        if (getId() != null) o.setId(getId());
        if (getIdBook() != null) o.setIdBook(getIdBook());
        if (getUrl() != null) o.setUrl(getUrl());
    }
}