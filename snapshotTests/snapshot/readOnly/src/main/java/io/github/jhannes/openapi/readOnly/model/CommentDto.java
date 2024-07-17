package io.github.jhannes.openapi.readOnly.model;

import java.time.OffsetDateTime;
import lombok.*;

@Data
public final class CommentDto {

    private String title = null;
    private String comment = null;
    private OffsetDateTime created_at = null;
    private UserDto user = null;

}