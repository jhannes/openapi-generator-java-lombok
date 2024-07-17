package io.github.jhannes.openapi.openid_configuration.model;

import lombok.*;

/**
 * Token response according to https://www.oauth.com/oauth2-servers/access-tokens/access-token-response/
 */
@Data
public final class TokenResponseDto {

    private String access_token;
    /**
     * The type of token this is. Always the string &#x27;bearer&#x27;
    */
    private String token_type;
    /**
     * The duration of time the access token is granted for in seconds
    */
    private Integer expires_in = null;
    /**
     * Space separated list of granted scopes for the access_token
    */
    private String scope = null;
    /**
     * JWT which has format base64(JwtHeader) + &#x27;.&#x27; base64(JwtPayload) + &#x27;.&#x27; + base64(signature)
    */
    private String id_token = null;
    private String refresh_token = null;

}