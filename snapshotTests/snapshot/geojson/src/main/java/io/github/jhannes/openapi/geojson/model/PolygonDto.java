package io.github.jhannes.openapi.geojson.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
public final class PolygonDto implements GeometryDto {

    private String type = "Polygon";
    private List<List<List<Double>>> coordinates = new ArrayList<>();

}