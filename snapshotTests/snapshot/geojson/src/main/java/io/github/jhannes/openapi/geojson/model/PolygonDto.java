package io.github.jhannes.openapi.geojson.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class PolygonDto implements GeometryDto {

    private String type = "Polygon";
    private List<List<List<Double>>> coordinates = new ArrayList<>();

    public boolean isEmpty() {
        return false;
    }

    public PolygonDto putAll(PolygonDto o) {
        if (o.getType() != null) setType(o.getType());
        if (o.getCoordinates() != null) setCoordinates(o.getCoordinates());
        return this;
    }

    public PolygonDto removeWhereEqual(PolygonDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getCoordinates() == null) fields.add(prefix + "coordinates");
        return fields;
    }

}