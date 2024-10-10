package io.github.jhannes.openapi.typeHierarchy.model;


import java.util.function.Supplier;
import java.util.List;
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

    public AddressDto sampleAddressDto(String propertyName) {
        return sampleAddressDto();
    }

    public AddressDto sampleAddressDto() {
        return new AddressDto()
            .setAddressLine1(sampleString("addressLine1"))
            .setAddressLine2(sampleString("addressLine2"))
            .setCity(sampleString("city"))
            .setCountry(sampleString("country"))
            .setAddressTypes(pickSome(AddressDto.AddressTypesEnum.values()));
    }

    public CatDto sampleCatDto(String propertyName) {
        return sampleCatDto();
    }

    public CatDto sampleCatDto() {
        return new CatDto()
            .setId(sampleString("id"))
            .setName(sampleString("name"))
            .setBirth_date(sampleString("birthDate"))
            .setOwnerAddress(sampleAddressDto("ownerAddress"))
            .setPet_type("Cat")
            .setHunts(sampleBoolean("hunts"))
            .setAge(sampleInteger("age"));
    }

    public DogDto sampleDogDto(String propertyName) {
        return sampleDogDto();
    }

    public DogDto sampleDogDto() {
        return new DogDto()
            .setId(sampleString("id"))
            .setName(sampleString("name"))
            .setBirth_date(sampleString("birthDate"))
            .setOwnerAddress(sampleAddressDto("ownerAddress"))
            .setPet_type("Dog")
            .setBark(sampleBoolean("bark"))
            .setBreed(pickOne(DogDto.BreedEnum.values()));
    }

    public GoldfishDto sampleGoldfishDto(String propertyName) {
        return sampleGoldfishDto();
    }

    public GoldfishDto sampleGoldfishDto() {
        return new GoldfishDto()
            .setPet_type("Goldfish")
            .setName(sampleString("name"))
            .setSpecies(sampleString("species"));
    }

    public PetBaseDto samplePetBaseDto(String propertyName) {
        return samplePetBaseDto();
    }

    public PetBaseDto samplePetBaseDto() {
        return new PetBaseDto()
            .setId(sampleString("id"))
            .setName(sampleString("name"))
            .setBirth_date(sampleString("birthDate"))
            .setOwnerAddress(sampleAddressDto("ownerAddress"));
    }

    public PetDto samplePetDto(String propertyName) {
        return samplePetDto();
    }

    public PetDto samplePetDto() {
        List<Supplier<PetDto>> factories = List.of(
            () -> sampleWorkingDogDto().setPet_type("WorkingDog"),
            () -> sampleCatDto().setPet_type("Cat"),
            () -> sampleGoldfishDto().setPet_type("Goldfish"),
            () -> sampleDogDto().setPet_type("Dog")
        );
        return pickOne(factories).get();
    }

    public WorkingDogCapabilityDto sampleWorkingDogCapabilityDto(String propertyName) {
        return sampleWorkingDogCapabilityDto();
    }

    public WorkingDogCapabilityDto sampleWorkingDogCapabilityDto() {
        return pickOne(WorkingDogCapabilityDto.values());
    }

    public WorkingDogDto sampleWorkingDogDto(String propertyName) {
        return sampleWorkingDogDto();
    }

    public WorkingDogDto sampleWorkingDogDto() {
        return new WorkingDogDto()
            .setId(sampleString("id"))
            .setName(sampleString("name"))
            .setBirth_date(sampleString("birthDate"))
            .setOwnerAddress(sampleAddressDto("ownerAddress"))
            .setBark(sampleBoolean("bark"))
            .setBreed(pickOne(WorkingDogDto.BreedEnum.values()))
            .setPet_type("WorkingDog");
    }

}
