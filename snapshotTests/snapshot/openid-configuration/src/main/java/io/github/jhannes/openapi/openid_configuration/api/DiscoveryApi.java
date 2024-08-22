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

public interface DiscoveryApi {
    /**
     * @return DiscoveryDocumentDto
     *
     * @see <a href="https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderConfig"> Documentation</a>
     */
    DiscoveryDocumentDto getDiscoveryDocument(
    ) throws IOException;
    /**
     * @return JwksDocumentDto
     *
     * @see <a href="https://datatracker.ietf.org/doc/html/rfc7517"> Documentation</a>
     */
    JwksDocumentDto getJwksDocument(
    ) throws IOException;
}
