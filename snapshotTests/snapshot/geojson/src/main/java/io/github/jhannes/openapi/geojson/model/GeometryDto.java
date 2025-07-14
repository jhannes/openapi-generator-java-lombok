package io.github.jhannes.openapi.geojson.model;

import java.util.List;

public sealed interface GeometryDto permits LineStringDto, PointDto, PolygonDto {

    String getType();

    static Class<? extends GeometryDto> getType(String type) {
        return switch (type) {
            case "Point" -> PointDto.class;
            case "Polygon" -> PolygonDto.class;
            case "LineString" -> LineStringDto.class;
            default -> throw new IllegalArgumentException("Illegal type " + type);
        };
    }

    static PointDto createPoint() {
        return new PointDto().setType("Point");
    }

    static PolygonDto createPolygon() {
        return new PolygonDto().setType("Polygon");
    }

    static LineStringDto createLineString() {
        return new LineStringDto().setType("LineString");
    }

    GeometryDto putAll(GeometryDto o);
    GeometryDto removeWhereEqual(GeometryDto o);
    boolean hasNoOptionalProperties();
    List<String> missingRequiredFields(String prefix);

    default void copyToLineString(LineStringDto o) {
    }
    default void copyToPoint(PointDto o) {
    }
    default void copyToPolygon(PolygonDto o) {
    }
}