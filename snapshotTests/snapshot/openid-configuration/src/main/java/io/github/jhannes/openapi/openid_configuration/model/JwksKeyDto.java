package io.github.jhannes.openapi.openid_configuration.model;

import lombok.*;

@Data
public final class JwksKeyDto {

    private String kty = null;
    private String use = null;
    private String kid;
    private String x5c;

}