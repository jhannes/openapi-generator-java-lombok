package io.github.jhannes.openapi.petstore.model;


import java.util.function.Supplier;
import java.util.List;
import java.util.Random;

/**
 * Model tests for OpenAPI Petstore
 */
public class SampleModelData extends SampleData {

    public SampleModelData(Random random) {
    	super(random);
    }

    public SampleModelData(long seed) {
        super(seed);
    }

    public CategoryDto sampleCategoryDto(String propertyName) {
        return sampleCategoryDto();
    }

    public CategoryDto sampleCategoryDto() {
        return new CategoryDto()
            .setId(sampleLong("id"))
            .setName(sampleString("name"));
    }

    public OrderDto sampleOrderDto(String propertyName) {
        return sampleOrderDto();
    }

    public OrderDto sampleOrderDto() {
        return new OrderDto()
            .setId(sampleLong("id"))
            .setPetId(sampleLong("petId"))
            .setQuantity(sampleInteger("quantity"))
            .setShipDate(sampleOffsetDateTime("shipDate"))
            .setStatus(pickOne(OrderDto.StatusEnum.values()))
            .setComplete(sampleBoolean("complete"));
    }

    public PetDto samplePetDto(String propertyName) {
        return samplePetDto();
    }

    public PetDto samplePetDto() {
        return new PetDto()
            .setId(sampleLong("id"))
            .setCategory(sampleCategoryDto("category"))
            .setName(sampleString("name"))
            .setStatus(pickOne(PetDto.StatusEnum.values()));
    }

    public TagDto sampleTagDto(String propertyName) {
        return sampleTagDto();
    }

    public TagDto sampleTagDto() {
        return new TagDto()
            .setId(sampleLong("id"))
            .setName(sampleString("name"));
    }

    public UserDto sampleUserDto(String propertyName) {
        return sampleUserDto();
    }

    public UserDto sampleUserDto() {
        return new UserDto()
            .setId(sampleLong("id"))
            .setUsername(sampleString("username"))
            .setFirstName(sampleString("firstName"))
            .setLastName(sampleString("lastName"))
            .setEmail(sampleString("email"))
            .setPassword(sampleString("password"))
            .setPhone(sampleString("phone"))
            .setUserStatus(sampleInteger("userStatus"));
    }

}
