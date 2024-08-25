package io.github.jhannes.openapi.reqres_in.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

@Data
public final class UserDto {

    private Integer id = null;
    private String email = null;
    private String first_name = null;
    private String last_name = null;
    private String avatar = null;

    public boolean isEmpty() {
        return getId() == null
                && getEmail() == null
                && getFirst_name() == null
                && getLast_name() == null
                && getAvatar() == null
        ;
    }

    public UserDto putAll(UserDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getEmail() != null) setEmail(o.getEmail());
        if (o.getFirst_name() != null) setFirst_name(o.getFirst_name());
        if (o.getLast_name() != null) setLast_name(o.getLast_name());
        if (o.getAvatar() != null) setAvatar(o.getAvatar());
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
        return List.of();
    }

}