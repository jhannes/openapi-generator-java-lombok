package io.github.jhannes.openapi.readOnly.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class CommentDto {

    private String title = null;
    private String comment = null;
    private OffsetDateTime created_at = null;
    private UserDto user = null;

    public boolean hasNoOptionalProperties() {
        return getTitle() == null
                && getComment() == null
                && getCreated_at() == null
                && getUser() == null
        ;
    }

    public CommentDto putAll(CommentDto o) {
        o.copyToComment(this);
        return this;
    }

    public CommentDto removeWhereEqual(CommentDto o) {
        if (Objects.equals(getTitle(), o.getTitle())) setTitle(null);
        if (Objects.equals(getComment(), o.getComment())) setComment(null);
        if (Objects.equals(getCreated_at(), o.getCreated_at())) setCreated_at(null);
        if (Objects.equals(getUser(), o.getUser())) setUser(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToComment(CommentDto o) {
        if (getTitle() != null) o.setTitle(getTitle());
        if (getComment() != null) o.setComment(getComment());
        if (getCreated_at() != null) o.setCreated_at(getCreated_at());
        if (getUser() != null) o.setUser(getUser());
    }
}