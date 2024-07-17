package io.github.jhannes.openapi.reqres_in.model;

import lombok.*;

@Data
public final class LoginPostRequestDto {

    private String username = null;
    private String email = null;
    private String password = null;

}