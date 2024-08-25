package io.github.jhannes.openapi.reqres_in.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

@Data
public final class RegisterPost200ResponseDto {

    private String id = null;
    private String token = null;

    public boolean isEmpty() {
        return getId() == null
                && getToken() == null
        ;
    }

    public RegisterPost200ResponseDto putAll(RegisterPost200ResponseDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getToken() != null) setToken(o.getToken());
        return this;
    }

    public RegisterPost200ResponseDto removeWhereEqual(RegisterPost200ResponseDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getToken(), o.getToken())) setToken(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}