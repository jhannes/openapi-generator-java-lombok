package io.github.jhannes.openapi.fakerestapi.model;

import lombok.*;

@Data
public final class UserDto {

    private Integer id = null;
    private String userName = null;
    private String password = null;

}