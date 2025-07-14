package io.github.jhannes.openapi.petstore.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class CategoryDto {

    private Long id = null;
    private String name = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getName() == null
        ;
    }

    public CategoryDto putAll(CategoryDto o) {
        o.copyToCategory(this);
        return this;
    }

    public CategoryDto removeWhereEqual(CategoryDto o) {
        o.removeWhereEqualFromCategory(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToCategory(CategoryDto o) {
        if (getId() != null) o.setId(getId());
        if (getName() != null) o.setName(getName());
    }

    public void removeWhereEqualFromCategory(CategoryDto o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getName(), o.getName())) o.setName(null);
    }
}