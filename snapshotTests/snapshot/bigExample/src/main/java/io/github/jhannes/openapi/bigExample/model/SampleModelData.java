package io.github.jhannes.openapi.bigExample.model;


import java.util.function.Supplier;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Model tests for Sample API
 */
public class SampleModelData extends SampleData {

    public SampleModelData(Random random) {
    	super(random);
    }

    public SampleModelData(long seed) {
        super(seed);
    }

    public PetDto samplePetDto(String propertyName) {
        return samplePetDto();
    }

    public PetDto samplePetDto() {
        return new PetDto()
            .setPet_type(sampleString("petType"))
            .setName(sampleString("name"))
            .setBirth_date(sampleLocalDate("birthDate"));
    }

    public PetLocationsDto samplePetLocationsDto(String propertyName) {
        return samplePetLocationsDto();
    }

    public PetLocationsDto samplePetLocationsDto() {
        return new PetLocationsDto()
            .setLocations(locationsForPetLocationsDto());
    }

    public Map<String, Map<String, List<Double>>> locationsForPetLocationsDto() {
        // Too complex to generate automatically. Subclass and override to customize
        return null;
    }

    public PetStoreDto samplePetStoreDto(String propertyName) {
        return samplePetStoreDto();
    }

    public PetStoreDto samplePetStoreDto() {
        return new PetStoreDto()
            .setPets(sampleMap(() -> samplePetDto("pets"), "pets"));
    }

}
