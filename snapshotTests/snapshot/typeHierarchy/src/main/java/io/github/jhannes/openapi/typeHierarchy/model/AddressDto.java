package io.github.jhannes.openapi.typeHierarchy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

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

    public boolean hasNoOptionalProperties() {
        return getAddressLine1() == null
                && getAddressLine2() == null
                && getAddressTypes() == null
        ;
    }

    public AddressDto putAll(AddressDto o) {
        if (o.getAddressLine1() != null) setAddressLine1(o.getAddressLine1());
        if (o.getAddressLine2() != null) setAddressLine2(o.getAddressLine2());
        if (o.getCity() != null) setCity(o.getCity());
        if (o.getCountry() != null) setCountry(o.getCountry());
        if (o.getAddressTypes() != null) setAddressTypes(o.getAddressTypes());
        return this;
    }

    public AddressDto removeWhereEqual(AddressDto o) {
        if (Objects.equals(getAddressLine1(), o.getAddressLine1())) setAddressLine1(null);
        if (Objects.equals(getAddressLine2(), o.getAddressLine2())) setAddressLine2(null);
        if (Objects.equals(getAddressTypes(), o.getAddressTypes())) setAddressTypes(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCity() == null) fields.add(prefix + "city");
        if (getCountry() == null) fields.add(prefix + "country");
        return fields;
    }

}