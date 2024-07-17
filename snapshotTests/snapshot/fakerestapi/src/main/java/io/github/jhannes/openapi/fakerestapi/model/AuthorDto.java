package io.github.jhannes.openapi.fakerestapi.model;

import lombok.*;

@Data
public final class AuthorDto {

    private Integer id = null;
    private Integer idBook = null;
    private String firstName = null;
    private String lastName = null;

}