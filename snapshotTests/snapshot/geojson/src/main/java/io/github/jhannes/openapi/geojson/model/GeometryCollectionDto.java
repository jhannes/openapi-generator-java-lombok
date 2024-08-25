package io.github.jhannes.openapi.geojson.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

/**
 * GeoJSon geometry collection
 */
@Data
public final class GeometryCollectionDto {

    private String type = "GeometryCollection";
    private List<GeometryDto> geometries = new ArrayList<>();

    public boolean isEmpty() {
        return false
        ;
    }

    public GeometryCollectionDto putAll(GeometryCollectionDto o) {
        if (o.getType() != null) setType(o.getType());
        if (o.getGeometries() != null) setGeometries(o.getGeometries());
        return this;
    }

    public GeometryCollectionDto removeWhereEqual(GeometryCollectionDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getGeometries() == null) fields.add(prefix + "geometries");
        return fields;
    }

}