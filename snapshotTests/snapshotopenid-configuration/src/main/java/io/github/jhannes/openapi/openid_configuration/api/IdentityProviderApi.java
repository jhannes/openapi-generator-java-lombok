package io.github.jhannes.openapi.openid_configuration.api;

import io.github.jhannes.openapi.openid_configuration.model.GrantTypeDto;
import io.github.jhannes.openapi.openid_configuration.model.OauthErrorDto;
import io.github.jhannes.openapi.openid_configuration.model.ResponseTypeDto;
import io.github.jhannes.openapi.openid_configuration.model.TokenResponseDto;
import java.net.URI;
import io.github.jhannes.openapi.openid_configuration.model.UserinfoDto;

import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;

public interface IdentityProviderApi {
    /**
     * @param grantType  (required)
     * @param code  (required)
     * @param clientId  (required)
     * @param authorization Used with token-exchange to validate client_name - use Basic authentication with client_id:client_secret (optional)
     * @param clientSecret  (optional)
     * @param redirectUri  (optional)
     * @param subjectToken Used with grant_type&#x3D;urn:ietf:params:oauth:grant-type:token-exchange to do a token exchange (optional)
     * @param audience Used with token-exchange to indicate which application the token will be used with (optional)
     * @return TokenResponseDto
     */
    TokenResponseDto fetchToken(
            GrantTypeDto grant_type,
            String code,
            String client_id,
            Optional<String> authorization,
            Optional<String> client_secret,
            Optional<URI> redirect_uri,
            Optional<String> subject_token,
            Optional<String> audience
    ) throws IOException;

    public static class FetchTokenHeaders {
        private String authorization;

        public FetchTokenHeaders authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
    }

    public static class FetchTokenForm {
        private GrantTypeDto grantType;

        public FetchTokenForm grantType(GrantTypeDto grantType) {
            this.grantType = grantType;
            return this;
        }
        private String code;

        public FetchTokenForm code(String code) {
            this.code = code;
            return this;
        }
        private String clientId;

        public FetchTokenForm clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }
        private String clientSecret;

        public FetchTokenForm clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }
        private URI redirectUri;

        public FetchTokenForm redirectUri(URI redirectUri) {
            this.redirectUri = redirectUri;
            return this;
        }
        private String subjectToken;

        public FetchTokenForm subjectToken(String subjectToken) {
            this.subjectToken = subjectToken;
            return this;
        }
        private String audience;

        public FetchTokenForm audience(String audience) {
            this.audience = audience;
            return this;
        }

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
     * @param authorization  (required)
     * @return UserinfoDto
     */
    UserinfoDto getUserinfo(
            String authorization
    ) throws IOException;

    public static class GetUserinfoHeaders {
        private String authorization;

        public GetUserinfoHeaders authorization(String authorization) {
            this.authorization = authorization;
            return this;
        }
    }
    /**
     * Starts an authentication flow. If the request is successful, the user is returned to the redirect_uri with a parameter, otherwise the user is redirected with an error parameter
     * @param clientId  (query) (required)
     * @param responseType  (query) (optional)
     * @param state  (query) (optional)
     * @param redirectUri  (query) (optional)
     * @param scope  (query) (optional)
     */
    void startAuthorization(
            String client_id,
            Optional<ResponseTypeDto> response_type,
            Optional<String> state,
            Optional<URI> redirect_uri,
            Optional<String> scope
    ) throws IOException;

    public static class StartAuthorizationQuery {
        private ResponseTypeDto responseType;

        public StartAuthorizationQuery responseType(ResponseTypeDto responseType) {
            this.responseType = responseType;
            return this;
        }
        private String clientId;

        public StartAuthorizationQuery clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }
        private String state;

        public StartAuthorizationQuery state(String state) {
            this.state = state;
            return this;
        }
        private URI redirectUri;

        public StartAuthorizationQuery redirectUri(URI redirectUri) {
            this.redirectUri = redirectUri;
            return this;
        }
        private String scope;

        public StartAuthorizationQuery scope(String scope) {
            this.scope = scope;
            return this;
        }

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
