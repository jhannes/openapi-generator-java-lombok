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
        o.copyToAddress(this);
        return this;
    }

    public AddressDto removeWhereEqual(AddressDto o) {
        o.removeWhereEqualFromAddress(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCity() == null) fields.add(prefix + "city");
        if (getCountry() == null) fields.add(prefix + "country");
        return fields;
    }

    public void copyToAddress(AddressDto o) {
        if (getAddressLine1() != null) o.setAddressLine1(getAddressLine1());
        if (getAddressLine2() != null) o.setAddressLine2(getAddressLine2());
        if (getCity() != null) o.setCity(getCity());
        if (getCountry() != null) o.setCountry(getCountry());
        if (getAddressTypes() != null) o.setAddressTypes(getAddressTypes());
    }

    public void removeWhereEqualFromAddress(AddressDto o) {
        if (Objects.equals(getAddressLine1(), o.getAddressLine1())) o.setAddressLine1(null);
        if (Objects.equals(getAddressLine2(), o.getAddressLine2())) o.setAddressLine2(null);
        if (Objects.equals(getAddressTypes(), o.getAddressTypes())) o.setAddressTypes(null);
    }
}