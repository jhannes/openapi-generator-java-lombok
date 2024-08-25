package io.github.jhannes.openapi.reqres_in.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

@Data
public final class LoginPost200ResponseDto {

    private String token = null;

    public boolean isEmpty() {
        return getToken() == null
        ;
    }

    public LoginPost200ResponseDto putAll(LoginPost200ResponseDto o) {
        if (o.getToken() != null) setToken(o.getToken());
        return this;
    }

    public LoginPost200ResponseDto removeWhereEqual(LoginPost200ResponseDto o) {
        if (Objects.equals(getToken(), o.getToken())) setToken(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}