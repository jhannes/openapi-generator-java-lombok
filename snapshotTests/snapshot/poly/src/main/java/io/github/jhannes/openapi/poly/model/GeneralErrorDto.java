package io.github.jhannes.openapi.poly.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class GeneralErrorDto implements CreationErrorDto, UpdateErrorDto {

    private String code;
    private String description;

    public boolean isEmpty() {
        return false;
    }

    public GeneralErrorDto putAll(GeneralErrorDto o) {
        if (o.getCode() != null) setCode(o.getCode());
        if (o.getDescription() != null) setDescription(o.getDescription());
        return this;
    }

    public GeneralErrorDto removeWhereEqual(GeneralErrorDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCode() == null) fields.add(prefix + "code");
        if (getDescription() == null) fields.add(prefix + "description");
        return fields;
    }

}