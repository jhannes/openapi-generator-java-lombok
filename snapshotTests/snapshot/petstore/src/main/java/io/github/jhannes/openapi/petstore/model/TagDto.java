package io.github.jhannes.openapi.petstore.model;

import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class TagDto {

    private Long id = null;
    private String name = null;

    public boolean empty() {
        return getId() == null
                && getName() == null
        ;
    }

    public TagDto putAll(TagDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getName() != null) setName(o.getName());
        return this;
    }

    public TagDto removeWhereEqual(TagDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getName(), o.getName())) setName(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}