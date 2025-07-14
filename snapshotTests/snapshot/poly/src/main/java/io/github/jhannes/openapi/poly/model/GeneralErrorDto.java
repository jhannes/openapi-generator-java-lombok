package io.github.jhannes.openapi.poly.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class GeneralErrorDto implements CreationErrorDto, UpdateErrorDto {

    private String code;
    private String description;

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public GeneralErrorDto putAll(GeneralErrorDto o) {
        o.copyToGeneralError(this);
        return this;
    }

    public GeneralErrorDto putAll(CreationErrorDto o) {
        o.copyToGeneralError(this);
        return this;
    }

    public GeneralErrorDto putAll(UpdateErrorDto o) {
        o.copyToGeneralError(this);
        return this;
    }

    public GeneralErrorDto removeWhereEqual(GeneralErrorDto o) {
        o.removeWhereEqualFromGeneralError(this);
        return this;
    }

    public GeneralErrorDto removeWhereEqual(CreationErrorDto o) {
        o.removeWhereEqualFromGeneralError(this);
        return this;
    }

    public GeneralErrorDto removeWhereEqual(UpdateErrorDto o) {
        o.removeWhereEqualFromGeneralError(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCode() == null) fields.add(prefix + "code");
        if (getDescription() == null) fields.add(prefix + "description");
        return fields;
    }

    public void copyToGeneralError(GeneralErrorDto o) {
        if (getDescription() != null) o.setDescription(getDescription());
    }
    public void copyToDuplicateIdentifierError(DuplicateIdentifierErrorDto o) {
    }
    public void copyToIllegalEmailAddressError(IllegalEmailAddressErrorDto o) {
    }

    public void removeWhereEqualFromGeneralError(GeneralErrorDto o) {
    }
    public void removeWhereEqualFromDuplicateIdentifierError(DuplicateIdentifierErrorDto o) {
    }
    public void removeWhereEqualFromIllegalEmailAddressError(IllegalEmailAddressErrorDto o) {
    }
}