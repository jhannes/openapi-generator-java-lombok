package io.github.jhannes.openapi.geojson.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class LineStringDto implements GeometryDto {

    private String type = "LineString";
    private List<List<Double>> coordinates = new ArrayList<>();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public LineStringDto putAll(LineStringDto o) {
        o.copyToLineString(this);
        return this;
    }

    public LineStringDto putAll(GeometryDto o) {
        o.copyToLineString(this);
        return this;
    }

    public LineStringDto removeWhereEqual(LineStringDto o) {
        o.removeWhereEqualFromLineString(this);
        return this;
    }

    public LineStringDto removeWhereEqual(GeometryDto o) {
        o.removeWhereEqualFromLineString(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getCoordinates() == null) fields.add(prefix + "coordinates");
        return fields;
    }

    public void copyToLineString(LineStringDto o) {
        if (getCoordinates() != null) o.setCoordinates(getCoordinates());
    }

    public void removeWhereEqualFromLineString(LineStringDto o) {
    }
}