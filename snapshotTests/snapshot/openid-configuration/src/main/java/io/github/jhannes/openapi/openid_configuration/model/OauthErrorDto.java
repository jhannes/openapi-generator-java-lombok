package io.github.jhannes.openapi.openid_configuration.model;

import lombok.*;

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

}