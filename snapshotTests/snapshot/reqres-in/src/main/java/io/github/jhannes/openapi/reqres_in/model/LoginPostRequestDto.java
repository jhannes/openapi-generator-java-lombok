package io.github.jhannes.openapi.reqres_in.model;

import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class LoginPostRequestDto {

    private String username = null;
    private String email = null;
    private String password = null;

    public boolean isEmpty() {
        return getUsername() == null
                && getEmail() == null
                && getPassword() == null
        ;
    }

    public LoginPostRequestDto putAll(LoginPostRequestDto o) {
        if (o.getUsername() != null) setUsername(o.getUsername());
        if (o.getEmail() != null) setEmail(o.getEmail());
        if (o.getPassword() != null) setPassword(o.getPassword());
        return this;
    }

    public LoginPostRequestDto removeWhereEqual(LoginPostRequestDto o) {
        if (Objects.equals(getUsername(), o.getUsername())) setUsername(null);
        if (Objects.equals(getEmail(), o.getEmail())) setEmail(null);
        if (Objects.equals(getPassword(), o.getPassword())) setPassword(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}