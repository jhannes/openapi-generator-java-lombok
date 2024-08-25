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

public interface IdentityClientApi {
    /**
     * Completes the authentication flow. This should be implemented by the openid connect client. The client should normally invoke the token endpoint with the code value provided by the identity provider.
     * @param state  (query) (optional)
     * @param code  (query) (optional)
     * @param error  (query) (optional)
     * @param error_description  (query) (optional)
     */
    void handleCallback(
            Optional<String> state,
            Optional<String> code,
            Optional<String> error,
            Optional<String> error_description,
            Consumer<String> setSetCookie,
            Consumer<URI> setLocation
    ) throws IOException;

    @Data
    class HandleCallbackQuery {
        private String state;
        private String code;
        private String error;
        private String errorDescription;

        public String toUrlEncoded() {
            List<String> parameters = new ArrayList<>();
            if (state != null) parameters.add("state=" + encode(state.toString(), UTF_8));
            if (code != null) parameters.add("code=" + encode(code.toString(), UTF_8));
            if (error != null) parameters.add("error=" + encode(error.toString(), UTF_8));
            if (errorDescription != null) parameters.add("error_description=" + encode(errorDescription.toString(), UTF_8));
            return String.join("&", parameters);
        }
    }
}
