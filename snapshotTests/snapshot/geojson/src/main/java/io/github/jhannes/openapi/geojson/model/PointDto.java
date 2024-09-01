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

    public boolean empty() {
        return true;
    }

    public PointDto putAll(PointDto o) {
        if (o.getType() != null) setType(o.getType());
        if (o.getCoordinates() != null) setCoordinates(o.getCoordinates());
        return this;
    }

    public PointDto removeWhereEqual(PointDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getCoordinates() == null) fields.add(prefix + "coordinates");
        return fields;
    }

}