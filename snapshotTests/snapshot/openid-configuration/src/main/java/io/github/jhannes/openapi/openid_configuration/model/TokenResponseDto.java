package io.github.jhannes.openapi.openid_configuration.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

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

    public boolean hasNoOptionalProperties() {
        return getExpires_in() == null
                && getScope() == null
                && getId_token() == null
                && getRefresh_token() == null
        ;
    }

    public TokenResponseDto putAll(TokenResponseDto o) {
        if (o.getAccess_token() != null) setAccess_token(o.getAccess_token());
        if (o.getToken_type() != null) setToken_type(o.getToken_type());
        if (o.getExpires_in() != null) setExpires_in(o.getExpires_in());
        if (o.getScope() != null) setScope(o.getScope());
        if (o.getId_token() != null) setId_token(o.getId_token());
        if (o.getRefresh_token() != null) setRefresh_token(o.getRefresh_token());
        return this;
    }

    public TokenResponseDto removeWhereEqual(TokenResponseDto o) {
        if (Objects.equals(getExpires_in(), o.getExpires_in())) setExpires_in(null);
        if (Objects.equals(getScope(), o.getScope())) setScope(null);
        if (Objects.equals(getId_token(), o.getId_token())) setId_token(null);
        if (Objects.equals(getRefresh_token(), o.getRefresh_token())) setRefresh_token(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getAccess_token() == null) fields.add(prefix + "accessToken");
        if (getToken_type() == null) fields.add(prefix + "tokenType");
        return fields;
    }

}