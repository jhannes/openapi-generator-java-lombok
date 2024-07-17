package io.github.jhannes.openapi.geojson.model;

import lombok.*;

public sealed interface GeometryDto permits LineStringDto, PointDto, PolygonDto {

    static Class<? extends GeometryDto> getType(String type) {
        return switch (type) {
            case "Point" -> PointDto.class;
            case "Polygon" -> PolygonDto.class;
            case "LineString" -> LineStringDto.class;
            default -> throw new IllegalArgumentException("Illegal type " + type);
        };
    }
}