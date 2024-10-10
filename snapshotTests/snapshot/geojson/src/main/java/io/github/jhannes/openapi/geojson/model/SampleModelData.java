package io.github.jhannes.openapi.geojson.model;


import java.util.function.Supplier;
import java.util.List;
import java.util.Random;

/**
 * Model tests for GeoJSON
 */
public class SampleModelData extends SampleData {

    public SampleModelData(Random random) {
    	super(random);
    }

    public SampleModelData(long seed) {
        super(seed);
    }

    public GeometryCollectionDto sampleGeometryCollectionDto(String propertyName) {
        return sampleGeometryCollectionDto();
    }

    public GeometryCollectionDto sampleGeometryCollectionDto() {
        return new GeometryCollectionDto()
            .setType("GeometryCollection");
    }

    public GeometryDto sampleGeometryDto(String propertyName) {
        return sampleGeometryDto();
    }

    public GeometryDto sampleGeometryDto() {
        List<Supplier<GeometryDto>> factories = List.of(
            () -> samplePointDto().setType("Point"),
            () -> samplePolygonDto().setType("Polygon"),
            () -> sampleLineStringDto().setType("LineString")
        );
        return pickOne(factories).get();
    }

    public LineStringDto sampleLineStringDto(String propertyName) {
        return sampleLineStringDto();
    }

    public LineStringDto sampleLineStringDto() {
        return new LineStringDto()
            .setType("LineString");
    }

    public PointDto samplePointDto(String propertyName) {
        return samplePointDto();
    }

    public PointDto samplePointDto() {
        return new PointDto()
            .setType("Point");
    }

    public PolygonDto samplePolygonDto(String propertyName) {
        return samplePolygonDto();
    }

    public PolygonDto samplePolygonDto() {
        return new PolygonDto()
            .setType("Polygon");
    }

}
