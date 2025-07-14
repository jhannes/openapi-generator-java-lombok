package io.github.jhannes.openapi.geojson.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * GeoJSon geometry collection
 */
@Data
public final class GeometryCollectionDto {

    private String type = "GeometryCollection";
    private List<GeometryDto> geometries = new ArrayList<>();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public GeometryCollectionDto putAll(GeometryCollectionDto o) {
        o.copyToGeometryCollection(this);
        return this;
    }

    public GeometryCollectionDto removeWhereEqual(GeometryCollectionDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getGeometries() != null) {
            for (int i = 0; i < getGeometries().size(); i++) {
                fields.addAll(getGeometries().get(i).missingRequiredFields(prefix + "geometries[" + i + "]."));
            }
        } else {
            fields.add(prefix + "geometries");
        }
        return fields;
    }

    public void copyToGeometryCollection(GeometryCollectionDto o) {
        if (getType() != null) o.setType(getType());
        if (getGeometries() != null) o.setGeometries(getGeometries());
    }
}