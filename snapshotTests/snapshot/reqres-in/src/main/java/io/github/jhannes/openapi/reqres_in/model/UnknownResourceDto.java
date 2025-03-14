package io.github.jhannes.openapi.reqres_in.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class UnknownResourceDto {

    private Integer id = null;
    private String name = null;
    private Integer year = null;
    private String color = null;
    private String pantone_value = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getName() == null
                && getYear() == null
                && getColor() == null
                && getPantone_value() == null
        ;
    }

    public UnknownResourceDto putAll(UnknownResourceDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getName() != null) setName(o.getName());
        if (o.getYear() != null) setYear(o.getYear());
        if (o.getColor() != null) setColor(o.getColor());
        if (o.getPantone_value() != null) setPantone_value(o.getPantone_value());
        return this;
    }

    public UnknownResourceDto removeWhereEqual(UnknownResourceDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getName(), o.getName())) setName(null);
        if (Objects.equals(getYear(), o.getYear())) setYear(null);
        if (Objects.equals(getColor(), o.getColor())) setColor(null);
        if (Objects.equals(getPantone_value(), o.getPantone_value())) setPantone_value(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

}