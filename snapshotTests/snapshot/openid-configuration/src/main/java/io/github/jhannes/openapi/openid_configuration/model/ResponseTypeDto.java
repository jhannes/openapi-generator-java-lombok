package io.github.jhannes.openapi.openid_configuration.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseTypeDto {
    code("code"),
    token("token"),
    id_token("id_token"),
    code_id_token("code id_token"),
    id_token_token("id_token token");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}