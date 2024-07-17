package io.github.jhannes.openapi.reqres_in.model;

import lombok.*;

@Data
public final class UserDto {

    private Integer id = null;
    private String email = null;
    private String first_name = null;
    private String last_name = null;
    private String avatar = null;

}