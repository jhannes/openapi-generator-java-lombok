package io.github.jhannes.openapi.reqres_in.model;


import java.util.function.Supplier;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Model tests for ReqRes API
 */
public class SampleModelData extends SampleData {

    public SampleModelData(Random random) {
    	super(random);
    }

    public SampleModelData(long seed) {
        super(seed);
    }

    public LoginPost200ResponseDto sampleLoginPost200ResponseDto(String propertyName) {
        return sampleLoginPost200ResponseDto();
    }

    public LoginPost200ResponseDto sampleLoginPost200ResponseDto() {
        return new LoginPost200ResponseDto()
            .setToken(sampleString("token"));
    }

    public LoginPost400ResponseDto sampleLoginPost400ResponseDto(String propertyName) {
        return sampleLoginPost400ResponseDto();
    }

    public LoginPost400ResponseDto sampleLoginPost400ResponseDto() {
        return new LoginPost400ResponseDto()
            .setError(sampleString("error"));
    }

    public LoginPostRequestDto sampleLoginPostRequestDto(String propertyName) {
        return sampleLoginPostRequestDto();
    }

    public LoginPostRequestDto sampleLoginPostRequestDto() {
        return new LoginPostRequestDto()
            .setUsername(sampleString("username"))
            .setEmail(sampleString("email"))
            .setPassword(sampleString("password"));
    }

    public RegisterPost200ResponseDto sampleRegisterPost200ResponseDto(String propertyName) {
        return sampleRegisterPost200ResponseDto();
    }

    public RegisterPost200ResponseDto sampleRegisterPost200ResponseDto() {
        return new RegisterPost200ResponseDto()
            .setId(sampleString("id"))
            .setToken(sampleString("token"));
    }

    public UnknownResourceDto sampleUnknownResourceDto(String propertyName) {
        return sampleUnknownResourceDto();
    }

    public UnknownResourceDto sampleUnknownResourceDto() {
        return new UnknownResourceDto()
            .setId(sampleInteger("id"))
            .setName(sampleString("name"))
            .setYear(sampleInteger("year"))
            .setColor(sampleString("color"))
            .setPantone_value(sampleString("pantoneValue"));
    }

    public UserDto sampleUserDto(String propertyName) {
        return sampleUserDto();
    }

    public UserDto sampleUserDto() {
        return new UserDto()
            .setId(sampleInteger("id"))
            .setEmail(sampleString("email"))
            .setFirst_name(sampleString("firstName"))
            .setLast_name(sampleString("lastName"))
            .setAvatar(sampleString("avatar"));
    }

    public UsersGet200ResponseDto sampleUsersGet200ResponseDto(String propertyName) {
        return sampleUsersGet200ResponseDto();
    }

    public UsersGet200ResponseDto sampleUsersGet200ResponseDto() {
        return new UsersGet200ResponseDto()
            .setPage(sampleInteger("page"))
            .setPer_page(sampleInteger("perPage"))
            .setTotal(sampleInteger("total"))
            .setTotal_pages(sampleInteger("totalPages"))
            .setData(sampleList(() -> sampleUserDto("data"), "data"));
    }

    public UsersIdGet200ResponseDto sampleUsersIdGet200ResponseDto(String propertyName) {
        return sampleUsersIdGet200ResponseDto();
    }

    public UsersIdGet200ResponseDto sampleUsersIdGet200ResponseDto() {
        return new UsersIdGet200ResponseDto()
            .setData(sampleUserDto("data"));
    }

    public UsersIdPut200ResponseDto sampleUsersIdPut200ResponseDto(String propertyName) {
        return sampleUsersIdPut200ResponseDto();
    }

    public UsersIdPut200ResponseDto sampleUsersIdPut200ResponseDto() {
        return new UsersIdPut200ResponseDto()
            .setUpdatedAt(sampleString("updatedAt"));
    }

}
