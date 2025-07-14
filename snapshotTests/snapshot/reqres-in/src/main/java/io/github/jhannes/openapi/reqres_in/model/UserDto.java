package io.github.jhannes.openapi.reqres_in.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class UserDto {

    private Integer id = null;
    private String email = null;
    private String first_name = null;
    private String last_name = null;
    private String avatar = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getEmail() == null
                && getFirst_name() == null
                && getLast_name() == null
                && getAvatar() == null
        ;
    }

    public UserDto putAll(UserDto o) {
        o.copyToUser(this);
        return this;
    }

    public UserDto removeWhereEqual(UserDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getEmail(), o.getEmail())) setEmail(null);
        if (Objects.equals(getFirst_name(), o.getFirst_name())) setFirst_name(null);
        if (Objects.equals(getLast_name(), o.getLast_name())) setLast_name(null);
        if (Objects.equals(getAvatar(), o.getAvatar())) setAvatar(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToUser(UserDto o) {
        if (getId() != null) o.setId(getId());
        if (getEmail() != null) o.setEmail(getEmail());
        if (getFirst_name() != null) o.setFirst_name(getFirst_name());
        if (getLast_name() != null) o.setLast_name(getLast_name());
        if (getAvatar() != null) o.setAvatar(getAvatar());
    }
}