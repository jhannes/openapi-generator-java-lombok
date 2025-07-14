package io.github.jhannes.openapi.fakerestapi.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class ActivityDto {

    private Integer id = null;
    private String title = null;
    private OffsetDateTime dueDate = null;
    private Boolean completed = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getTitle() == null
                && getDueDate() == null
                && getCompleted() == null
        ;
    }

    public ActivityDto putAll(ActivityDto o) {
        o.copyToActivity(this);
        return this;
    }

    public ActivityDto removeWhereEqual(ActivityDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getTitle(), o.getTitle())) setTitle(null);
        if (Objects.equals(getDueDate(), o.getDueDate())) setDueDate(null);
        if (Objects.equals(getCompleted(), o.getCompleted())) setCompleted(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToActivity(ActivityDto o) {
        if (getId() != null) o.setId(getId());
        if (getTitle() != null) o.setTitle(getTitle());
        if (getDueDate() != null) o.setDueDate(getDueDate());
        if (getCompleted() != null) o.setCompleted(getCompleted());
    }
}