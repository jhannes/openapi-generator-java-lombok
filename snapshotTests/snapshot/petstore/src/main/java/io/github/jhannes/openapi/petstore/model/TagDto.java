package io.github.jhannes.openapi.petstore.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class TagDto {

    private Long id = null;
    private String name = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getName() == null
        ;
    }

    public TagDto putAll(TagDto o) {
        o.copyToTag(this);
        return this;
    }

    public TagDto removeWhereEqual(TagDto o) {
        o.removeWhereEqualFromTag(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToTag(TagDto o) {
        if (getId() != null) o.setId(getId());
        if (getName() != null) o.setName(getName());
    }

    public void removeWhereEqualFromTag(TagDto o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getName(), o.getName())) o.setName(null);
    }
}