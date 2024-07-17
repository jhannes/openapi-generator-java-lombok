package io.github.jhannes.openapi.poly.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
public final class IllegalEmailAddressErrorDto implements CreationErrorDto, UpdateErrorDto {

    private String code;
    private String inputEmailAddress;
    private List<String> validDomains = new ArrayList<>();

}