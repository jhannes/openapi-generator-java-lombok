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
        o.copyToUnknownResource(this);
        return this;
    }

    public UnknownResourceDto removeWhereEqual(UnknownResourceDto o) {
        o.removeWhereEqualFromUnknownResource(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToUnknownResource(UnknownResourceDto o) {
        if (getId() != null) o.setId(getId());
        if (getName() != null) o.setName(getName());
        if (getYear() != null) o.setYear(getYear());
        if (getColor() != null) o.setColor(getColor());
        if (getPantone_value() != null) o.setPantone_value(getPantone_value());
    }

    public void removeWhereEqualFromUnknownResource(UnknownResourceDto o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getName(), o.getName())) o.setName(null);
        if (Objects.equals(getYear(), o.getYear())) o.setYear(null);
        if (Objects.equals(getColor(), o.getColor())) o.setColor(null);
        if (Objects.equals(getPantone_value(), o.getPantone_value())) o.setPantone_value(null);
    }
}