package io.github.jhannes.openapi.websockets.model;

import lombok.*;

public sealed interface RecipientInterface permits RecipientDto, PersonInterface {

    String getEmail();
    RecipientInterface setEmail(String email);

}
