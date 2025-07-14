package io.github.jhannes.openapi.readOnly.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.Data;

@Data
public final class UserDto {

    private UUID id = null;
    private String name = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getName() == null
        ;
    }

    public UserDto putAll(UserDto o) {
        o.copyToUser(this);
        return this;
    }

    public UserDto removeWhereEqual(UserDto o) {
        o.removeWhereEqualFromUser(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToUser(UserDto o) {
        if (getId() != null) o.setId(getId());
        if (getName() != null) o.setName(getName());
    }

    public void removeWhereEqualFromUser(UserDto o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getName(), o.getName())) o.setName(null);
    }
}