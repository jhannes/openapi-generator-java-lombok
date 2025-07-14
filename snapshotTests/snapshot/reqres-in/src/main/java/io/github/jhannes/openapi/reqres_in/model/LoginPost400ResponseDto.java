package io.github.jhannes.openapi.reqres_in.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class LoginPost400ResponseDto {

    private String error = null;

    public boolean hasNoOptionalProperties() {
        return getError() == null
        ;
    }

    public LoginPost400ResponseDto putAll(LoginPost400ResponseDto o) {
        o.copyTo_login_post_400_response(this);
        return this;
    }

    public LoginPost400ResponseDto removeWhereEqual(LoginPost400ResponseDto o) {
        if (Objects.equals(getError(), o.getError())) setError(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyTo_login_post_400_response(LoginPost400ResponseDto o) {
        if (getError() != null) o.setError(getError());
    }
}