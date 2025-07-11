package io.github.jhannes.openapi.typeHierarchy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public final class CatDto extends PetBaseDto implements PetDto {

    private String pet_type = "Cat";
    private Boolean hunts = null;
    private Integer age = null;

    @Override
    public CatDto setId(String id) {
        super.setId(id);
        return this;
    }

    @Override
    public CatDto setName(String name) {
        super.setName(name);
        return this;
    }

    @Override
    public CatDto setBirth_date(String birthDate) {
        super.setBirth_date(birthDate);
        return this;
    }

    @Override
    public CatDto setOwnerAddress(AddressDto ownerAddress) {
        super.setOwnerAddress(ownerAddress);
        return this;
    }

    public boolean hasNoOptionalProperties() {
        return super.hasNoOptionalProperties()
                && getHunts() == null
                && getAge() == null
        ;
    }

    public CatDto putAll(PetBaseDto o) {
        super.putAll(o);
        return this;
    }

    public CatDto putAll(CatDto o) {
        super.putAll(o);
        if (o.getHunts() != null) setHunts(o.getHunts());
        if (o.getAge() != null) setAge(o.getAge());
        return this;
    }

    public CatDto putAll(PetDto o) {
        if (o instanceof PetBaseDto base) putAll(base);
        return this;
    }

    public CatDto removeWhereEqual(CatDto o) {
        super.removeWhereEqual(o);
        if (Objects.equals(getHunts(), o.getHunts())) setHunts(null);
        if (Objects.equals(getAge(), o.getAge())) setAge(null);
        return this;
    }

    public CatDto removeWhereEqual(PetDto o) {
        if (o instanceof PetBaseDto base) removeWhereEqual(base);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = super.missingRequiredFields(prefix);
        if (getPet_type() == null) fields.add(prefix + "pet_type");
        return fields;
    }

}