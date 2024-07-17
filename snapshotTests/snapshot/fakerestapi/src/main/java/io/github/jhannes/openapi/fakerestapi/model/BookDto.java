package io.github.jhannes.openapi.fakerestapi.model;

import java.time.OffsetDateTime;
import lombok.*;

@Data
public final class BookDto {

    private Integer id = null;
    private String title = null;
    private String description = null;
    private Integer pageCount = null;
    private String excerpt = null;
    private OffsetDateTime publishDate = null;

}