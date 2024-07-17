package io.github.jhannes.openapi.openid_configuration.api;

import io.github.jhannes.openapi.openid_configuration.model.DiscoveryDocumentDto;
import io.github.jhannes.openapi.openid_configuration.model.JwksDocumentDto;

import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;

public interface DiscoveryApi {
    /**
     * @return DiscoveryDocumentDto
     */
    DiscoveryDocumentDto getDiscoveryDocument(
    ) throws IOException;
    /**
     * @return JwksDocumentDto
     */
    JwksDocumentDto getJwksDocument(
    ) throws IOException;
}
