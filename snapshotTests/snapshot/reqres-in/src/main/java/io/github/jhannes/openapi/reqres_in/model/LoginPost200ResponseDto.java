package io.github.jhannes.openapi.reqres_in.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class LoginPost200ResponseDto {

    private String token = null;

    public boolean hasNoOptionalProperties() {
        return getToken() == null
        ;
    }

    public LoginPost200ResponseDto putAll(LoginPost200ResponseDto o) {
        o.copyTo_login_post_200_response(this);
        return this;
    }

    public LoginPost200ResponseDto removeWhereEqual(LoginPost200ResponseDto o) {
        if (Objects.equals(getToken(), o.getToken())) setToken(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyTo_login_post_200_response(LoginPost200ResponseDto o) {
        if (getToken() != null) o.setToken(getToken());
    }
}