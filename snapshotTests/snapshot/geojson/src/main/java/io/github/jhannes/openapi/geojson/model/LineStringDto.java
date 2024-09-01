package io.github.jhannes.openapi.geojson.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class LineStringDto implements GeometryDto {

    private String type = "LineString";
    private List<List<Double>> coordinates = new ArrayList<>();

    public boolean empty() {
        return true;
    }

    public LineStringDto putAll(LineStringDto o) {
        if (o.getType() != null) setType(o.getType());
        if (o.getCoordinates() != null) setCoordinates(o.getCoordinates());
        return this;
    }

    public LineStringDto removeWhereEqual(LineStringDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getCoordinates() == null) fields.add(prefix + "coordinates");
        return fields;
    }

}