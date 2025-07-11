package io.github.jhannes.openapi.poly.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class IllegalEmailAddressErrorDto implements CreationErrorDto, UpdateErrorDto {

    private String code;
    private String inputEmailAddress;
    private List<String> validDomains = new ArrayList<>();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public IllegalEmailAddressErrorDto putAll(IllegalEmailAddressErrorDto o) {
        if (o.getInputEmailAddress() != null) setInputEmailAddress(o.getInputEmailAddress());
        if (o.getValidDomains() != null) setValidDomains(o.getValidDomains());
        return this;
    }

    public IllegalEmailAddressErrorDto putAll(CreationErrorDto o) {
        if (o instanceof IllegalEmailAddressErrorDto same) putAll(same);
        return this;
    }

    public IllegalEmailAddressErrorDto putAll(UpdateErrorDto o) {
        if (o instanceof IllegalEmailAddressErrorDto same) putAll(same);
        return this;
    }

    public IllegalEmailAddressErrorDto removeWhereEqual(IllegalEmailAddressErrorDto o) {
        return this;
    }

    public IllegalEmailAddressErrorDto removeWhereEqual(CreationErrorDto o) {
        if (o instanceof IllegalEmailAddressErrorDto same) removeWhereEqual(same);
        return this;
    }

    public IllegalEmailAddressErrorDto removeWhereEqual(UpdateErrorDto o) {
        if (o instanceof IllegalEmailAddressErrorDto same) removeWhereEqual(same);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCode() == null) fields.add(prefix + "code");
        if (getInputEmailAddress() == null) fields.add(prefix + "inputEmailAddress");
        if (getValidDomains() == null) fields.add(prefix + "validDomains");
        return fields;
    }

}