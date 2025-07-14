package io.github.jhannes.openapi.reqres_in.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class LoginPostRequestDto {

    private String username = null;
    private String email = null;
    private String password = null;

    public boolean hasNoOptionalProperties() {
        return getUsername() == null
                && getEmail() == null
                && getPassword() == null
        ;
    }

    public LoginPostRequestDto putAll(LoginPostRequestDto o) {
        o.copyTo_login_post_request(this);
        return this;
    }

    public LoginPostRequestDto removeWhereEqual(LoginPostRequestDto o) {
        o.removeWhereEqualFrom_login_post_request(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyTo_login_post_request(LoginPostRequestDto o) {
        if (getUsername() != null) o.setUsername(getUsername());
        if (getEmail() != null) o.setEmail(getEmail());
        if (getPassword() != null) o.setPassword(getPassword());
    }

    public void removeWhereEqualFrom_login_post_request(LoginPostRequestDto o) {
        if (Objects.equals(getUsername(), o.getUsername())) o.setUsername(null);
        if (Objects.equals(getEmail(), o.getEmail())) o.setEmail(null);
        if (Objects.equals(getPassword(), o.getPassword())) o.setPassword(null);
    }
}