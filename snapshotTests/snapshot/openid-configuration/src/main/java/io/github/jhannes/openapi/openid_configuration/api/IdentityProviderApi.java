package io.github.jhannes.openapi.openid_configuration.api;

import io.github.jhannes.openapi.openid_configuration.model.*;

import lombok.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.time.*;
import java.util.*;
import java.util.function.*;

import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;

public interface IdentityProviderApi {
    /**
     * Starts an authentication flow. If the request is successful, the user is returned to the redirect_uri with a parameter, otherwise the user is redirected with an error parameter
     * @param response_type  (query) (required)
     * @param client_id  (query) (required)
     * @param redirect_uri  (query) (required)
     * @param response_mode  (query) (optional)
     * @param state  (query) (optional)
     * @param scope  (query) (optional)
     * @param login_hint  (query) (optional)
     * @param prompt  (query) (optional
     * @param acr_values Requested Authentication Context Class Reference values. Space-separated string that specifies the acr values that the Authorization Server is being requested to use for processing this Authentication Request, with the values appearing in order of preference. The Authentication Context Class satisfied by the authentication performed is returned as the acr Claim Value, as specified in Section 2 (query) (optional
     * @param nonce OPTIONAL. String value used to associate a Client session with an ID Token, and to mitigate replay attacks. The value is passed through unmodified from the Authentication Request to the ID Token (query) (optional)
     * @param display  (query) (optional)
     * 
     * @see <a href="https://openid.net/specs/openid-connect-core-1_0.html#AuthRequest"> Documentation</a>
     */
    void authorization(
            ResponseTypeDto response_type,
            String client_id,
            URI redirect_uri,
            Optional<String> response_mode,
            Optional<String> state,
            Optional<String> scope,
            Optional<String> login_hint,
            Optional<List<String>> prompt,
            Optional<List<String>> acr_values,
            Optional<String> nonce,
            Optional<String> display
    ) throws IOException;

    @Data
    class AuthorizationQuery {
        private ResponseTypeDto responseType;
        private String responseMode;
        private String clientId;
        private String state;
        private URI redirectUri;
        private String scope;
        private String loginHint;
        private List<String> prompt;
        private List<String> acrValues;
        private String nonce;
        private String display;

        public String toUrlEncoded() {
            List<String> parameters = new ArrayList<>();
            if (responseType != null) {
                parameters.add("response_type=" + encode(responseType.toString(), UTF_8));
            }
            if (responseMode != null) {
                parameters.add("response_mode=" + encode(responseMode.toString(), UTF_8));
            }
            if (clientId != null) {
                parameters.add("client_id=" + encode(clientId.toString(), UTF_8));
            }
            if (state != null) {
                parameters.add("state=" + encode(state.toString(), UTF_8));
            }
            if (redirectUri != null) {
                parameters.add("redirect_uri=" + encode(redirectUri.toString(), UTF_8));
            }
            if (scope != null) {
                parameters.add("scope=" + encode(scope.toString(), UTF_8));
            }
            if (loginHint != null) {
                parameters.add("login_hint=" + encode(loginHint.toString(), UTF_8));
            }
            if (prompt != null) {
                parameters.add("prompt=" + encode(prompt.toString(), UTF_8));
            }
            if (acrValues != null) {
                parameters.add("acr_values=" + encode(acrValues.toString(), UTF_8));
            }
            if (nonce != null) {
                parameters.add("nonce=" + encode(nonce.toString(), UTF_8));
            }
            if (display != null) {
                parameters.add("display=" + encode(display.toString(), UTF_8));
            }
            return String.join("&", parameters);
        }
    }
    /**
     * @param grant_type  (required)
     * @param code  (required)
     * @param client_id  (required)
     * @param Authorization Used with token-exchange to validate client_name - use Basic authentication with client_id:client_secret (optional)
     * @param client_secret  (optional)
     * @param redirect_uri  (optional)
     * @param subject_token Used with grant_type&#x3D;urn:ietf:params:oauth:grant-type:token-exchange to do a token exchange (optional)
     * @param audience Used with token-exchange to indicate which application the token will be used with (optional)
     * @return TokenResponseDto
     */
    TokenResponseDto fetchToken(
            GrantTypeDto grant_type,
            String code,
            String client_id,
            Optional<String> Authorization,
            Optional<String> client_secret,
            Optional<URI> redirect_uri,
            Optional<String> subject_token,
            Optional<String> audience
    ) throws IOException;

    @Data
    class FetchTokenHeaders {
        private String authorization;
    }

    @Data
    class FetchTokenForm {
        private GrantTypeDto grantType;
        private String code;
        private String clientId;
        private String clientSecret;
        private URI redirectUri;
        private String subjectToken;
        private String audience;

        public String toUrlEncoded() {
            List<String> parameters = new ArrayList<>();
            if (grantType != null) {
                parameters.add("grant_type=" + encode(grantType.toString(), UTF_8));
            }
            if (code != null) {
                parameters.add("code=" + encode(code.toString(), UTF_8));
            }
            if (clientId != null) {
                parameters.add("client_id=" + encode(clientId.toString(), UTF_8));
            }
            if (clientSecret != null) {
                parameters.add("client_secret=" + encode(clientSecret.toString(), UTF_8));
            }
            if (redirectUri != null) {
                parameters.add("redirect_uri=" + encode(redirectUri.toString(), UTF_8));
            }
            if (subjectToken != null) {
                parameters.add("subject_token=" + encode(subjectToken.toString(), UTF_8));
            }
            if (audience != null) {
                parameters.add("audience=" + encode(audience.toString(), UTF_8));
            }
            return String.join("&", parameters);
        }
    }
    /**
     * Returns information about the currently logged in user
     * @param Authorization  (required)
     * @return UserinfoDto
     */
    UserinfoDto getUserinfo(
            String Authorization
    ) throws IOException;

    @Data
    class GetUserinfoHeaders {
        private String authorization;
    }
}
