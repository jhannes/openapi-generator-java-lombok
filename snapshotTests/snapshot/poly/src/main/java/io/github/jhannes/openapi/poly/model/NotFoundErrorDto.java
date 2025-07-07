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
        if (o.getIdentifierValue() != null) setIdentifierValue(o.getIdentifierValue());
        if (o.getEntityType() != null) setEntityType(o.getEntityType());
        return this;
    }

    public NotFoundErrorDto putAll(UpdateErrorDto o) {
        if (o instanceof NotFoundErrorDto same) putAll(same);
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

}