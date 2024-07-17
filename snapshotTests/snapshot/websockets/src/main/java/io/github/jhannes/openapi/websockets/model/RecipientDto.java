package io.github.jhannes.openapi.websockets.model;

import lombok.*;

@Data
public sealed class RecipientDto permits PersonDto {

    private String email = null;

}