package io.github.jhannes.openapi.geojson.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
public final class LineStringDto implements GeometryDto {

    private String type = "LineString";
    private List<List<Double>> coordinates = new ArrayList<>();

}