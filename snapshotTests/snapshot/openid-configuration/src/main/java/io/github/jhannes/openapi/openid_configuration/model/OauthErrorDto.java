package io.github.jhannes.openapi.openid_configuration.model;

import lombok.*;

@Data
public final class OauthErrorDto {

    @Getter
    @RequiredArgsConstructor
    public enum ErrorEnum {
        INVALID_REQUEST("invalid_request"),
        INVALID_CLIENT("invalid_client"),
        INVALID_GRANT("invalid_grant"),
        UNAUTHORIZED_CLIENT("unauthorized_client"),
        UNSUPPORTED_GRANT_TYPE("unsupported_grant_type"),
        INVALID_SCOPE("invalid_scope");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    private ErrorEnum error;
    private String error_description;

}