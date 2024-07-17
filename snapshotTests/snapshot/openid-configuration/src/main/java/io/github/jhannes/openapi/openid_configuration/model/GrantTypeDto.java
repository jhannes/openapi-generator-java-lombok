package io.github.jhannes.openapi.openid_configuration.model;

import lombok.*;

@Getter
@RequiredArgsConstructor
public enum GrantTypeDto {
    IMPLICIT("implicit"),
    AUTHORIZATION_CODE("authorization_code"),
    CLIENT_CREDENTIALS("client_credentials"),
    REFRESH_TOKEN("refresh_token"),
    URN_IETF_PARAMS_OAUTH_GRANT_TYPE_TOKEN_EXCHANGE("urn:ietf:params:oauth:grant-type:token-exchange");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}