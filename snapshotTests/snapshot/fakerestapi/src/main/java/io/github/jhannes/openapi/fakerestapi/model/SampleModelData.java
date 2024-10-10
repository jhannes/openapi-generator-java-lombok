package io.github.jhannes.openapi.fakerestapi.model;


import java.util.function.Supplier;
import java.util.List;
import java.util.Random;

/**
 * Model tests for FakeRESTApi.Web V1
 */
public class SampleModelData extends SampleData {

    public SampleModelData(Random random) {
    	super(random);
    }

    public SampleModelData(long seed) {
        super(seed);
    }

    public ActivityDto sampleActivityDto(String propertyName) {
        return sampleActivityDto();
    }

    public ActivityDto sampleActivityDto() {
        return new ActivityDto()
            .setId(sampleInteger("id"))
            .setTitle(sampleString("title"))
            .setDueDate(sampleOffsetDateTime("dueDate"))
            .setCompleted(sampleBoolean("completed"));
    }

    public AuthorDto sampleAuthorDto(String propertyName) {
        return sampleAuthorDto();
    }

    public AuthorDto sampleAuthorDto() {
        return new AuthorDto()
            .setId(sampleInteger("id"))
            .setIdBook(sampleInteger("idBook"))
            .setFirstName(sampleString("firstName"))
            .setLastName(sampleString("lastName"));
    }

    public BookDto sampleBookDto(String propertyName) {
        return sampleBookDto();
    }

    public BookDto sampleBookDto() {
        return new BookDto()
            .setId(sampleInteger("id"))
            .setTitle(sampleString("title"))
            .setDescription(sampleString("description"))
            .setPageCount(sampleInteger("pageCount"))
            .setExcerpt(sampleString("excerpt"))
            .setPublishDate(sampleOffsetDateTime("publishDate"));
    }

    public CoverPhotoDto sampleCoverPhotoDto(String propertyName) {
        return sampleCoverPhotoDto();
    }

    public CoverPhotoDto sampleCoverPhotoDto() {
        return new CoverPhotoDto()
            .setId(sampleInteger("id"))
            .setIdBook(sampleInteger("idBook"))
            .setUrl(sampleURI("url"));
    }

    public UserDto sampleUserDto(String propertyName) {
        return sampleUserDto();
    }

    public UserDto sampleUserDto() {
        return new UserDto()
            .setId(sampleInteger("id"))
            .setUserName(sampleString("userName"))
            .setPassword(sampleString("password"));
    }

}
