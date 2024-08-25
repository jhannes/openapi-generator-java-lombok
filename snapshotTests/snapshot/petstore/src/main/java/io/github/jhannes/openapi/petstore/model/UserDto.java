package io.github.jhannes.openapi.petstore.model;

import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class UserDto {

    private Long id = null;
    private String username = null;
    private String firstName = null;
    private String lastName = null;
    private String email = null;
    private String password = null;
    private String phone = null;
    /**
     * User Status
    */
    private Integer userStatus = null;

    public boolean isEmpty() {
        return getId() == null
                && getUsername() == null
                && getFirstName() == null
                && getLastName() == null
                && getEmail() == null
                && getPassword() == null
                && getPhone() == null
                && getUserStatus() == null
        ;
    }

    public UserDto putAll(UserDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getUsername() != null) setUsername(o.getUsername());
        if (o.getFirstName() != null) setFirstName(o.getFirstName());
        if (o.getLastName() != null) setLastName(o.getLastName());
        if (o.getEmail() != null) setEmail(o.getEmail());
        if (o.getPassword() != null) setPassword(o.getPassword());
        if (o.getPhone() != null) setPhone(o.getPhone());
        if (o.getUserStatus() != null) setUserStatus(o.getUserStatus());
        return this;
    }

    public UserDto removeWhereEqual(UserDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getUsername(), o.getUsername())) setUsername(null);
        if (Objects.equals(getFirstName(), o.getFirstName())) setFirstName(null);
        if (Objects.equals(getLastName(), o.getLastName())) setLastName(null);
        if (Objects.equals(getEmail(), o.getEmail())) setEmail(null);
        if (Objects.equals(getPassword(), o.getPassword())) setPassword(null);
        if (Objects.equals(getPhone(), o.getPhone())) setPhone(null);
        if (Objects.equals(getUserStatus(), o.getUserStatus())) setUserStatus(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}