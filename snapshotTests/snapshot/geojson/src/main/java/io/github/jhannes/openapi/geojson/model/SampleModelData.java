package io.github.jhannes.openapi.geojson.model;


import java.util.function.Supplier;
import java.util.List;
import java.util.Map;
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
            .setType("GeometryCollection")
            .setGeometries(sampleList(() -> sampleGeometryDto("geometries"), "geometries"));
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
            .setType("LineString")
            .setCoordinates(coordinatesForLineStringDto());
    }

    public List<List<Double>> coordinatesForLineStringDto() {
        // Too complex to generate automatically. Subclass and override to customize
        return null;
    }

    public PointDto samplePointDto(String propertyName) {
        return samplePointDto();
    }

    public PointDto samplePointDto() {
        return new PointDto()
            .setType("Point")
            .setCoordinates(sampleList(() -> sampleDouble("coordinates"), "coordinates"));
    }

    public PolygonDto samplePolygonDto(String propertyName) {
        return samplePolygonDto();
    }

    public PolygonDto samplePolygonDto() {
        return new PolygonDto()
            .setType("Polygon")
            .setCoordinates(coordinatesForPolygonDto());
    }

    public List<List<List<Double>>> coordinatesForPolygonDto() {
        // Too complex to generate automatically. Subclass and override to customize
        return null;
    }

}
