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
        o.copyToTokenResponse(this);
        return this;
    }

    public TokenResponseDto removeWhereEqual(TokenResponseDto o) {
        o.removeWhereEqualFromTokenResponse(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getAccess_token() == null) fields.add(prefix + "access_token");
        if (getToken_type() == null) fields.add(prefix + "token_type");
        return fields;
    }

    public void copyToTokenResponse(TokenResponseDto o) {
        if (getAccess_token() != null) o.setAccess_token(getAccess_token());
        if (getToken_type() != null) o.setToken_type(getToken_type());
        if (getExpires_in() != null) o.setExpires_in(getExpires_in());
        if (getScope() != null) o.setScope(getScope());
        if (getId_token() != null) o.setId_token(getId_token());
        if (getRefresh_token() != null) o.setRefresh_token(getRefresh_token());
    }

    public void removeWhereEqualFromTokenResponse(TokenResponseDto o) {
        if (Objects.equals(getExpires_in(), o.getExpires_in())) o.setExpires_in(null);
        if (Objects.equals(getScope(), o.getScope())) o.setScope(null);
        if (Objects.equals(getId_token(), o.getId_token())) o.setId_token(null);
        if (Objects.equals(getRefresh_token(), o.getRefresh_token())) o.setRefresh_token(null);
    }
}