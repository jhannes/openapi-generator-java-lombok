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

public interface BooksApi {
    /**
     * @return List&lt;BookDto&gt;
     */
    List<BookDto> apiV1BooksGet(
    ) throws IOException;
    /**
     * @param id  (path) (required)
     */
    void apiV1BooksIdDelete(
            Integer id
    ) throws IOException;
    /**
     * @param id  (path) (required)
     * @return BookDto
     */
    BookDto apiV1BooksIdGet(
            Integer id
    ) throws IOException;
    /**
     * @param id  (path) (required)
     * @param BookDto  (optional)
     */
    void apiV1BooksIdPut(
            Integer id,
            Optional<BookDto> BookDto
    ) throws IOException;
    /**
     * @param BookDto  (optional)
     */
    void apiV1BooksPost(
            Optional<BookDto> BookDto
    ) throws IOException;
}
