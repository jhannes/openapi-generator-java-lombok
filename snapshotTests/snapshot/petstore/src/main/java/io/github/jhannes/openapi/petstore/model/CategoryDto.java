package io.github.jhannes.openapi.petstore.model;

import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class CategoryDto {

    private Long id = null;
    private String name = null;

    public boolean empty() {
        return getId() == null
                && getName() == null
        ;
    }

    public CategoryDto putAll(CategoryDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getName() != null) setName(o.getName());
        return this;
    }

    public CategoryDto removeWhereEqual(CategoryDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getName(), o.getName())) setName(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}