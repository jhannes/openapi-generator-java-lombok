package io.github.jhannes.openapi.poly.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class DuplicateIdentifierErrorDto implements CreationErrorDto, UpdateErrorDto {

    private String code;
    private String identifierValue = null;
    private String entityType;

    public boolean hasNoOptionalProperties() {
        return getIdentifierValue() == null
        ;
    }

    public DuplicateIdentifierErrorDto putAll(DuplicateIdentifierErrorDto o) {
        o.copyToDuplicateIdentifierError(this);
        return this;
    }

    public DuplicateIdentifierErrorDto putAll(CreationErrorDto o) {
        o.copyToDuplicateIdentifierError(this);
        return this;
    }

    public DuplicateIdentifierErrorDto putAll(UpdateErrorDto o) {
        o.copyToDuplicateIdentifierError(this);
        return this;
    }

    public DuplicateIdentifierErrorDto removeWhereEqual(DuplicateIdentifierErrorDto o) {
        if (Objects.equals(getIdentifierValue(), o.getIdentifierValue())) setIdentifierValue(null);
        return this;
    }

    public DuplicateIdentifierErrorDto removeWhereEqual(CreationErrorDto o) {
        if (o instanceof DuplicateIdentifierErrorDto same) removeWhereEqual(same);
        return this;
    }

    public DuplicateIdentifierErrorDto removeWhereEqual(UpdateErrorDto o) {
        if (o instanceof DuplicateIdentifierErrorDto same) removeWhereEqual(same);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCode() == null) fields.add(prefix + "code");
        if (getEntityType() == null) fields.add(prefix + "entityType");
        return fields;
    }

    public void copyToDuplicateIdentifierError(DuplicateIdentifierErrorDto o) {
        if (getIdentifierValue() != null) o.setIdentifierValue(getIdentifierValue());
        if (getEntityType() != null) o.setEntityType(getEntityType());
    }
    public void copyToGeneralError(GeneralErrorDto o) {
    }
    public void copyToIllegalEmailAddressError(IllegalEmailAddressErrorDto o) {
    }
}