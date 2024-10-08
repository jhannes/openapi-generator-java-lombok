package io.github.jhannes.openapi.openid_configuration.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GrantTypeDto {
    implicit("implicit"),
    authorization_code("authorization_code"),
    client_credentials("client_credentials"),
    refresh_token("refresh_token"),
    urn_ietf_params_oauth_grant_type_token_exchange("urn:ietf:params:oauth:grant-type:token-exchange");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}