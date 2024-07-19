package io.github.jhannes.openapi.openid_configuration.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public final class JwtPayloadDto extends HashMap<String, List> {

    /**
     * Issuer - the URI for the login provider
    */
    private String iss;
    /**
     * Subject - the unique identifier for the logged in user
    */
    private String sub;
    /**
     * Audience - the client_id that the JWT was issued to
    */
    private String aud;
    /**
     * The name of the logged in user
    */
    private String name = null;
    /**
     * The email of the logged in user
    */
    private String email = null;
    /**
     * The unique identifier of the organization that the user has selected
    */
    private String orgId = null;
    /**
     * The name of the organization that the user has selected
    */
    private String org = null;
    /**
     * For JWT from ID-porten, contains national identity number
    */
    private String pid = null;

}