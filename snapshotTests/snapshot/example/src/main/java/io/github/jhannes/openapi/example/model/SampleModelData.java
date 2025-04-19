package io.github.jhannes.openapi.example.model;


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
            .setPet_type(samplePetTypeDto("petType"))
            .setName(sampleString("name"))
            .setBirth_date(sampleLocalDate("birthDate"));
    }

    public PetTypeDto samplePetTypeDto(String propertyName) {
        return samplePetTypeDto();
    }

    public PetTypeDto samplePetTypeDto() {
        return pickOne(PetTypeDto.values());
    }

}
