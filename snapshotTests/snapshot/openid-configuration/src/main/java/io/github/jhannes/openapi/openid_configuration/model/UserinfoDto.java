package io.github.jhannes.openapi.openid_configuration.model;

import lombok.*;

@Data
public final class UserinfoDto {

    /**
     * Subject identifier
    */
    private String sub;
    private String name = null;
    private Object email = null;

}