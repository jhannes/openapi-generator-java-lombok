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
    /**
     * Starts an authentication flow. If the request is successful, the user is returned to the redirect_uri with a parameter, otherwise the user is redirected with an error parameter
     * @param client_id  (query) (required)
     * @param response_type  (query) (optional)
     * @param state  (query) (optional)
     * @param redirect_uri  (query) (optional)
     * @param scope  (query) (optional)
     */
    void startAuthorization(
            String client_id,
            Optional<ResponseTypeDto> response_type,
            Optional<String> state,
            Optional<URI> redirect_uri,
            Optional<String> scope
    ) throws IOException;

    @Data
    class StartAuthorizationQuery {
        private ResponseTypeDto responseType;
        private String clientId;
        private String state;
        private URI redirectUri;
        private String scope;

        public String toUrlEncoded() {
            List<String> parameters = new ArrayList<>();
            if (responseType != null) {
                parameters.add("response_type=" + encode(responseType.toString(), UTF_8));
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
            return String.join("&", parameters);
        }
    }
}
