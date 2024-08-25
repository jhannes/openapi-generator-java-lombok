package io.github.jhannes.openapi.readOnly.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

@Data
public final class CommentDto {

    private String title = null;
    private String comment = null;
    private OffsetDateTime created_at = null;
    private UserDto user = null;

    public boolean isEmpty() {
        return getTitle() == null
                && getComment() == null
                && getCreated_at() == null
                && getUser() == null
        ;
    }

    public CommentDto putAll(CommentDto o) {
        if (o.getTitle() != null) setTitle(o.getTitle());
        if (o.getComment() != null) setComment(o.getComment());
        if (o.getCreated_at() != null) setCreated_at(o.getCreated_at());
        if (o.getUser() != null) setUser(o.getUser());
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
        return List.of();
    }

}