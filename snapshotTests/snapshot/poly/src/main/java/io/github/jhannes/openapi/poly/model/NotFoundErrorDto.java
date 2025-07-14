package io.github.jhannes.openapi.poly.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class NotFoundErrorDto implements UpdateErrorDto {

    private String code;
    private String identifierValue = null;
    private String entityType;

    public boolean hasNoOptionalProperties() {
        return getIdentifierValue() == null
        ;
    }

    public NotFoundErrorDto putAll(NotFoundErrorDto o) {
        o.copyToNotFoundError(this);
        return this;
    }

    public NotFoundErrorDto putAll(UpdateErrorDto o) {
        o.copyToNotFoundError(this);
        return this;
    }

    public NotFoundErrorDto removeWhereEqual(NotFoundErrorDto o) {
        if (Objects.equals(getIdentifierValue(), o.getIdentifierValue())) setIdentifierValue(null);
        return this;
    }

    public NotFoundErrorDto removeWhereEqual(UpdateErrorDto o) {
        if (o instanceof NotFoundErrorDto same) removeWhereEqual(same);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCode() == null) fields.add(prefix + "code");
        if (getEntityType() == null) fields.add(prefix + "entityType");
        return fields;
    }

    public void copyToNotFoundError(NotFoundErrorDto o) {
        if (getIdentifierValue() != null) o.setIdentifierValue(getIdentifierValue());
        if (getEntityType() != null) o.setEntityType(getEntityType());
    }
}