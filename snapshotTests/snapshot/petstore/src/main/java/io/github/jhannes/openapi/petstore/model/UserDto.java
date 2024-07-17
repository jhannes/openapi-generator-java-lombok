package io.github.jhannes.openapi.petstore.model;

import lombok.*;

@Data
public final class UserDto {

    private Long id = null;
    private String username = null;
    private String firstName = null;
    private String lastName = null;
    private String email = null;
    private String password = null;
    private String phone = null;
    /**
     * User Status
    */
    private Integer userStatus = null;

}