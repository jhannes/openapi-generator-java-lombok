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

public interface CoverPhotosApi {
    /**
     * @param idBook  (path) (required)
     * @return List&lt;CoverPhotoDto&gt;
     */
    List<CoverPhotoDto> apiV1CoverPhotosBooksCoversIdBookGet(
            Integer idBook
    ) throws IOException;
    /**
     * @return List&lt;CoverPhotoDto&gt;
     */
    List<CoverPhotoDto> apiV1CoverPhotosGet(
    ) throws IOException;
    /**
     * @param id  (path) (required)
     */
    void apiV1CoverPhotosIdDelete(
            Integer id
    ) throws IOException;
    /**
     * @param id  (path) (required)
     * @return CoverPhotoDto
     */
    CoverPhotoDto apiV1CoverPhotosIdGet(
            Integer id
    ) throws IOException;
    /**
     * @param id  (path) (required)
     * @param CoverPhotoDto  (optional)
     * @return CoverPhotoDto
     */
    CoverPhotoDto apiV1CoverPhotosIdPut(
            Integer id,
            Optional<CoverPhotoDto> CoverPhotoDto
    ) throws IOException;
    /**
     * @param CoverPhotoDto  (optional)
     * @return CoverPhotoDto
     */
    CoverPhotoDto apiV1CoverPhotosPost(
            Optional<CoverPhotoDto> CoverPhotoDto
    ) throws IOException;
}
