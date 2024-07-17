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

public interface UsersApi {
    /**
     * @return List&lt;UserDto&gt;
     */
    List<UserDto> apiV1UsersGet(
    ) throws IOException;
    /**
     * @param id  (path) (required)
     */
    void apiV1UsersIdDelete(
            Integer id
    ) throws IOException;
    /**
     * @param id  (path) (required)
     */
    void apiV1UsersIdGet(
            Integer id
    ) throws IOException;
    /**
     * @param id  (path) (required)
     * @param UserDto  (optional)
     */
    void apiV1UsersIdPut(
            Integer id,
            Optional<UserDto> UserDto
    ) throws IOException;
    /**
     * @param UserDto  (optional)
     */
    void apiV1UsersPost(
            Optional<UserDto> UserDto
    ) throws IOException;
}
