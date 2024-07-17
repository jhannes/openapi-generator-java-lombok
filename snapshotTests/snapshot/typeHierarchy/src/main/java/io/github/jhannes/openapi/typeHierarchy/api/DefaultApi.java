package io.github.jhannes.openapi.typeHierarchy.api;

import io.github.jhannes.openapi.typeHierarchy.model.PetDto;

import lombok.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;

public interface DefaultApi {
    /**
     * @param PetDto  (optional)
     */
    void petsPost(
            Optional<PetDto> PetDto
    ) throws IOException;
}
