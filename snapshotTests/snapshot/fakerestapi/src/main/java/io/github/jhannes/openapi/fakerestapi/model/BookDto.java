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
        if (o.getId() != null) setId(o.getId());
        if (o.getTitle() != null) setTitle(o.getTitle());
        if (o.getDescription() != null) setDescription(o.getDescription());
        if (o.getPageCount() != null) setPageCount(o.getPageCount());
        if (o.getExcerpt() != null) setExcerpt(o.getExcerpt());
        if (o.getPublishDate() != null) setPublishDate(o.getPublishDate());
        return this;
    }

    public BookDto removeWhereEqual(BookDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getTitle(), o.getTitle())) setTitle(null);
        if (Objects.equals(getDescription(), o.getDescription())) setDescription(null);
        if (Objects.equals(getPageCount(), o.getPageCount())) setPageCount(null);
        if (Objects.equals(getExcerpt(), o.getExcerpt())) setExcerpt(null);
        if (Objects.equals(getPublishDate(), o.getPublishDate())) setPublishDate(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

}