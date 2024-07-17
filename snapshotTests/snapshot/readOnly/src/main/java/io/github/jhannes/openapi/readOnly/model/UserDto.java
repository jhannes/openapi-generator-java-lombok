package io.github.jhannes.openapi.readOnly.model;

import java.util.UUID;
import lombok.*;

@Data
public final class UserDto {

    private UUID id = null;
    private String name = null;

}