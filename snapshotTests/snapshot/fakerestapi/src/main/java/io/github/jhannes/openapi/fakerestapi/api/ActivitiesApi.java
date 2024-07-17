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

public interface ActivitiesApi {
    /**
     * @return List&lt;ActivityDto&gt;
     */
    List<ActivityDto> apiV1ActivitiesGet(
    ) throws IOException;
    /**
     * @param id  (path) (required)
     */
    void apiV1ActivitiesIdDelete(
            Integer id
    ) throws IOException;
    /**
     * @param id  (path) (required)
     * @return ActivityDto
     */
    ActivityDto apiV1ActivitiesIdGet(
            Integer id
    ) throws IOException;
    /**
     * @param id  (path) (required)
     * @param ActivityDto  (optional)
     * @return ActivityDto
     */
    ActivityDto apiV1ActivitiesIdPut(
            Integer id,
            Optional<ActivityDto> ActivityDto
    ) throws IOException;
    /**
     * @param ActivityDto  (optional)
     * @return ActivityDto
     */
    ActivityDto apiV1ActivitiesPost(
            Optional<ActivityDto> ActivityDto
    ) throws IOException;
}
