package io.github.jhannes.openapi.typeHierarchy.api;

import io.github.jhannes.openapi.typeHierarchy.model.PetDto;

import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;

public interface DefaultApi {
    /**
     * @param petDto  (optional)
     */
    void petsPost(
            PetDto petDto
    ) throws IOException;
}
