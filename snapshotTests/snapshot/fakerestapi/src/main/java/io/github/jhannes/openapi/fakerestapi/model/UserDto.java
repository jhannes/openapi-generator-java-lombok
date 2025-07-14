package io.github.jhannes.openapi.fakerestapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class UserDto {

    private Integer id = null;
    private String userName = null;
    private String password = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getUserName() == null
                && getPassword() == null
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
        if (getUserName() != null) o.setUserName(getUserName());
        if (getPassword() != null) o.setPassword(getPassword());
    }

    public void removeWhereEqualFromUser(UserDto o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getUserName(), o.getUserName())) o.setUserName(null);
        if (Objects.equals(getPassword(), o.getPassword())) o.setPassword(null);
    }
}