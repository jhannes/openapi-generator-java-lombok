package io.github.jhannes.openapi.geojson.api;

import io.github.jhannes.openapi.geojson.model.*;

import lombok.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.time.*;
import java.util.*;
import java.util.function.*;

import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;

public interface DefaultApi {
    /**
     * @return GeometryDto
     */
    GeometryDto getGeometry(
    ) throws IOException;
    /**
     * @return GeometryCollectionDto
     */
    GeometryCollectionDto getLocation(
    ) throws IOException;
    /**
     * @return PolygonDto
     */
    PolygonDto getPolygon(
    ) throws IOException;
}
