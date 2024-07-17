package io.github.jhannes.openapi.fakerestapi.api;

import io.github.jhannes.openapi.fakerestapi.model.*;

import lombok.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.time.*;
import java.util.*;
import java.util.function.*;

import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;

public interface AuthorsApi {
    /**
     * @param idBook  (path) (required)
     * @return List&lt;AuthorDto&gt;
     */
    List<AuthorDto> apiV1AuthorsAuthorsBooksIdBookGet(
            Integer idBook
    ) throws IOException;
    /**
     * @return List&lt;AuthorDto&gt;
     */
    List<AuthorDto> apiV1AuthorsGet(
    ) throws IOException;
    /**
     * @param id  (path) (required)
     */
    void apiV1AuthorsIdDelete(
            Integer id
    ) throws IOException;
    /**
     * @param id  (path) (required)
     * @return AuthorDto
     */
    AuthorDto apiV1AuthorsIdGet(
            Integer id
    ) throws IOException;
    /**
     * @param id  (path) (required)
     * @param AuthorDto  (optional)
     * @return AuthorDto
     */
    AuthorDto apiV1AuthorsIdPut(
            Integer id,
            Optional<AuthorDto> AuthorDto
    ) throws IOException;
    /**
     * @param AuthorDto  (optional)
     * @return AuthorDto
     */
    AuthorDto apiV1AuthorsPost(
            Optional<AuthorDto> AuthorDto
    ) throws IOException;
}
