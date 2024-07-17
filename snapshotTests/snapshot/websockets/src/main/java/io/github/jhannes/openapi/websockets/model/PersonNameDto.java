package io.github.jhannes.openapi.websockets.model;

import lombok.*;

@Data
public final class PersonNameDto {

    private String givenName = null;
    private String familyName = null;

}