package io.github.jhannes.openapi.geojson.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
public final class PointDto implements GeometryDto {

    private String type = "Point";
    /**
     * Point in 3D space
    */
    private List<Double> coordinates = new ArrayList<>();

}