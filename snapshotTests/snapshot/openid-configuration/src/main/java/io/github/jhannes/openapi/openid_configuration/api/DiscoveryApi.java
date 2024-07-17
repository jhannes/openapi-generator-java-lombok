package io.github.jhannes.openapi.openid_configuration.api;

import io.github.jhannes.openapi.openid_configuration.model.DiscoveryDocumentDto;
import io.github.jhannes.openapi.openid_configuration.model.JwksDocumentDto;

import lombok.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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
