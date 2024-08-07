package io.github.jhannes.openapi.typeHierarchy.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
public final class AddressDto {

    @Getter
    @RequiredArgsConstructor
    public enum AddressTypesEnum {
        SHIPPING("SHIPPING"),
        BILLING("BILLING");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    private String addressLine1 = null;
    private String addressLine2 = null;
    private String city;
    private String country;
    private List<AddressTypesEnum> addressTypes = new ArrayList<>();

}