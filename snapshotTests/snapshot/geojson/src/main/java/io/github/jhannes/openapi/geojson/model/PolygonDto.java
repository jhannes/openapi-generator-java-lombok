package io.github.jhannes.openapi.geojson.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class PolygonDto implements GeometryDto {

    private String type = "Polygon";
    private List<List<List<Double>>> coordinates = new ArrayList<>();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public PolygonDto putAll(PolygonDto o) {
        o.copyToPolygon(this);
        return this;
    }

    public PolygonDto putAll(GeometryDto o) {
        o.copyToPolygon(this);
        return this;
    }

    public PolygonDto removeWhereEqual(PolygonDto o) {
        o.removeWhereEqualFromPolygon(this);
        return this;
    }

    public PolygonDto removeWhereEqual(GeometryDto o) {
        o.removeWhereEqualFromPolygon(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getCoordinates() == null) fields.add(prefix + "coordinates");
        return fields;
    }

    public void copyToPolygon(PolygonDto o) {
        if (getCoordinates() != null) o.setCoordinates(getCoordinates());
    }

    public void removeWhereEqualFromPolygon(PolygonDto o) {
    }
}