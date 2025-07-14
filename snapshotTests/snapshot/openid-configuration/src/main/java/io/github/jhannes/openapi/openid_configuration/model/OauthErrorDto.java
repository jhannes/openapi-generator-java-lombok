package io.github.jhannes.openapi.openid_configuration.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
public final class OauthErrorDto {

    @Getter
    @RequiredArgsConstructor
    public enum ErrorEnum {
        invalid_request("invalid_request"),
        invalid_client("invalid_client"),
        invalid_grant("invalid_grant"),
        unauthorized_client("unauthorized_client"),
        unsupported_grant_type("unsupported_grant_type"),
        invalid_scope("invalid_scope");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    private ErrorEnum error;
    private String error_description;

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public OauthErrorDto putAll(OauthErrorDto o) {
        o.copyToOauthError(this);
        return this;
    }

    public OauthErrorDto removeWhereEqual(OauthErrorDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getError() == null) fields.add(prefix + "error");
        if (getError_description() == null) fields.add(prefix + "error_description");
        return fields;
    }

    public void copyToOauthError(OauthErrorDto o) {
        if (getError() != null) o.setError(getError());
        if (getError_description() != null) o.setError_description(getError_description());
    }
}