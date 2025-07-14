package io.github.jhannes.openapi.geojson.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class PointDto implements GeometryDto {

    private String type = "Point";
    /**
     * Point in 3D space
    */
    private List<Double> coordinates = new ArrayList<>();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public PointDto putAll(PointDto o) {
        o.copyToPoint(this);
        return this;
    }

    public PointDto putAll(GeometryDto o) {
        o.copyToPoint(this);
        return this;
    }

    public PointDto removeWhereEqual(PointDto o) {
        return this;
    }

    public PointDto removeWhereEqual(GeometryDto o) {
        if (o instanceof PointDto same) removeWhereEqual(same);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getCoordinates() == null) fields.add(prefix + "coordinates");
        return fields;
    }

    public void copyToPoint(PointDto o) {
        if (getCoordinates() != null) o.setCoordinates(getCoordinates());
    }
}