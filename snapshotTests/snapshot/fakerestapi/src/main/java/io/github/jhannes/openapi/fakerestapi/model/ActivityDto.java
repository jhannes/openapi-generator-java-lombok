package io.github.jhannes.openapi.fakerestapi.model;

import java.time.OffsetDateTime;
import lombok.*;

@Data
public final class ActivityDto {

    private Integer id = null;
    private String title = null;
    private OffsetDateTime dueDate = null;
    private Boolean completed = null;

}