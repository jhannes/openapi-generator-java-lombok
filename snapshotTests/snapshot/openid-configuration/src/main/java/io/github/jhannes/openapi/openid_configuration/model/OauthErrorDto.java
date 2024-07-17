package io.github.jhannes.openapi.openid_configuration.model;

import lombok.*;

@Data
public final class OauthErrorDto {

    private String error;
    private String error_description;

}