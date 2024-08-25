package io.github.jhannes.openapi.fakerestapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

@Data
public final class UserDto {

    private Integer id = null;
    private String userName = null;
    private String password = null;

    public boolean isEmpty() {
        return getId() == null
                && getUserName() == null
                && getPassword() == null
        ;
    }

    public UserDto putAll(UserDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getUserName() != null) setUserName(o.getUserName());
        if (o.getPassword() != null) setPassword(o.getPassword());
        return this;
    }

    public UserDto removeWhereEqual(UserDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getUserName(), o.getUserName())) setUserName(null);
        if (Objects.equals(getPassword(), o.getPassword())) setPassword(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}