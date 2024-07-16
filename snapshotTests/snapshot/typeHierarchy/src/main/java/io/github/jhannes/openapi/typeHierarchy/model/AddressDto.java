package io.github.jhannes.openapi.typeHierarchy.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import lombok.RequiredArgsConstructor;

@Data
public class AddressDto {
    @Getter @ToString @RequiredArgsConstructor
    public enum AddressTypesEnum {
        SHIPPING("SHIPPING"),
        BILLING("BILLING");
    
        private final String name;
    }

    private String addressLine1 = null;
    private String addressLine2 = null;
    private String city;
    private String country;
    private List<AddressTypesEnum> addressTypes = new ArrayList<>();

}