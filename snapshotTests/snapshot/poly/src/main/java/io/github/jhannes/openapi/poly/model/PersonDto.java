package io.github.jhannes.openapi.poly.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Data
public final class PersonDto implements AnyPartyDto {

    private UUID id = null;
    private String type;
    private String givenName;
    private String familyName;
    private String email = null;
    private String phone = null;
    private LocalDate birthDate = null;

}