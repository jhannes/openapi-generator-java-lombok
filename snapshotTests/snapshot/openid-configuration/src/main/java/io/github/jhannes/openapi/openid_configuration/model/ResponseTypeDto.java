package io.github.jhannes.openapi.openid_configuration.model;

import lombok.*;

@Getter
@RequiredArgsConstructor
public enum ResponseTypeDto {
    CODE("code"),
    TOKEN("token"),
    ID_TOKEN("id_token"),
    CODE_ID_TOKEN("code id_token"),
    ID_TOKEN_TOKEN("id_token token");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}