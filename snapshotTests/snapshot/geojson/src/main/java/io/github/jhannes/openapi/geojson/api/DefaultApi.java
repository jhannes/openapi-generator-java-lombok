package io.github.jhannes.openapi.geojson.api;

import io.github.jhannes.openapi.geojson.model.GeometryCollectionDto;
import io.github.jhannes.openapi.geojson.model.GeometryDto;
import io.github.jhannes.openapi.geojson.model.PolygonDto;

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
