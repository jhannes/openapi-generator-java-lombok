package io.github.jhannes.openapi.petstore.model;

import java.util.ArrayList;
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

    public boolean hasNoOptionalProperties() {
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
        if (getUsername() != null) o.setUsername(getUsername());
        if (getFirstName() != null) o.setFirstName(getFirstName());
        if (getLastName() != null) o.setLastName(getLastName());
        if (getEmail() != null) o.setEmail(getEmail());
        if (getPassword() != null) o.setPassword(getPassword());
        if (getPhone() != null) o.setPhone(getPhone());
        if (getUserStatus() != null) o.setUserStatus(getUserStatus());
    }

    public void removeWhereEqualFromUser(UserDto o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getUsername(), o.getUsername())) o.setUsername(null);
        if (Objects.equals(getFirstName(), o.getFirstName())) o.setFirstName(null);
        if (Objects.equals(getLastName(), o.getLastName())) o.setLastName(null);
        if (Objects.equals(getEmail(), o.getEmail())) o.setEmail(null);
        if (Objects.equals(getPassword(), o.getPassword())) o.setPassword(null);
        if (Objects.equals(getPhone(), o.getPhone())) o.setPhone(null);
        if (Objects.equals(getUserStatus(), o.getUserStatus())) o.setUserStatus(null);
    }
}