package io.github.jhannes.openapi.fakerestapi.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class BookDto {

    private Integer id = null;
    private String title = null;
    private String description = null;
    private Integer pageCount = null;
    private String excerpt = null;
    private OffsetDateTime publishDate = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getTitle() == null
                && getDescription() == null
                && getPageCount() == null
                && getExcerpt() == null
                && getPublishDate() == null
        ;
    }

    public BookDto putAll(BookDto o) {
        o.copyToBook(this);
        return this;
    }

    public BookDto removeWhereEqual(BookDto o) {
        o.removeWhereEqualFromBook(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToBook(BookDto o) {
        if (getId() != null) o.setId(getId());
        if (getTitle() != null) o.setTitle(getTitle());
        if (getDescription() != null) o.setDescription(getDescription());
        if (getPageCount() != null) o.setPageCount(getPageCount());
        if (getExcerpt() != null) o.setExcerpt(getExcerpt());
        if (getPublishDate() != null) o.setPublishDate(getPublishDate());
    }

    public void removeWhereEqualFromBook(BookDto o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getTitle(), o.getTitle())) o.setTitle(null);
        if (Objects.equals(getDescription(), o.getDescription())) o.setDescription(null);
        if (Objects.equals(getPageCount(), o.getPageCount())) o.setPageCount(null);
        if (Objects.equals(getExcerpt(), o.getExcerpt())) o.setExcerpt(null);
        if (Objects.equals(getPublishDate(), o.getPublishDate())) o.setPublishDate(null);
    }
}