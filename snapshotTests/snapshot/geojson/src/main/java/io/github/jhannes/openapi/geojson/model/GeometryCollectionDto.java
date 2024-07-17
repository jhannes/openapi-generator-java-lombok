package io.github.jhannes.openapi.geojson.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

/**
 * GeoJSon geometry collection
 */
@Data
public final class GeometryCollectionDto {

    private String type = "GeometryCollection";
    private List<GeometryDto> geometries = new ArrayList<>();

}