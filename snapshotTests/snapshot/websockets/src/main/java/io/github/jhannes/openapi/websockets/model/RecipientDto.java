package io.github.jhannes.openapi.websockets.model;

import lombok.*;

@Data
public sealed class RecipientDto implements RecipientInterface permits PersonDto {

    private String email = null;

}