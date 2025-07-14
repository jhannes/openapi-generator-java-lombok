package io.github.jhannes.openapi.reqres_in.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class RegisterPost200ResponseDto {

    private String id = null;
    private String token = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getToken() == null
        ;
    }

    public RegisterPost200ResponseDto putAll(RegisterPost200ResponseDto o) {
        o.copyTo_register_post_200_response(this);
        return this;
    }

    public RegisterPost200ResponseDto removeWhereEqual(RegisterPost200ResponseDto o) {
        o.removeWhereEqualFrom_register_post_200_response(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyTo_register_post_200_response(RegisterPost200ResponseDto o) {
        if (getId() != null) o.setId(getId());
        if (getToken() != null) o.setToken(getToken());
    }

    public void removeWhereEqualFrom_register_post_200_response(RegisterPost200ResponseDto o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getToken(), o.getToken())) o.setToken(null);
    }
}