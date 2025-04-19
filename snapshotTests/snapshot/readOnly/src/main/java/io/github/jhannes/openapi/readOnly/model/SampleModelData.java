package io.github.jhannes.openapi.readOnly.model;


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

    public CommentDto sampleCommentDto(String propertyName) {
        return sampleCommentDto();
    }

    public CommentDto sampleCommentDto() {
        return new CommentDto()
            .setTitle(sampleString("title"))
            .setComment(sampleString("comment"))
            .setCreated_at(sampleOffsetDateTime("createdAt"))
            .setUser(sampleUserDto("user"));
    }

    public PetDto samplePetDto(String propertyName) {
        return samplePetDto();
    }

    public PetDto samplePetDto() {
        return new PetDto()
            .setId(sampleUUID("id"))
            .setPet_type(pickOne(PetDto.PetTypeEnum.values()))
            .setName(sampleString("name"))
            .setBirth_date(sampleLocalDate("birthDate"))
            .setCreated_at(sampleOffsetDateTime("createdAt"))
            .setComments(sampleList(() -> sampleCommentDto("comments"), "comments"))
            .setStatus(pickOne(PetDto.StatusEnum.values()));
    }

    public UserDto sampleUserDto(String propertyName) {
        return sampleUserDto();
    }

    public UserDto sampleUserDto() {
        return new UserDto()
            .setId(sampleUUID("id"))
            .setName(sampleString("name"));
    }

}
