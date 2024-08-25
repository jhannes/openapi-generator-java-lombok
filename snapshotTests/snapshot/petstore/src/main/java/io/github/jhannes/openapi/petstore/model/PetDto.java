package io.github.jhannes.openapi.petstore.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
public final class PetDto {

    /**
     * pet status in the store
     */
    @Getter
    @RequiredArgsConstructor
    public enum StatusEnum {
        available("available"),
        pending("pending"),
        sold("sold");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    private Long id = null;
    private CategoryDto category = null;
    private String name;
    private List<String> photoUrls = new ArrayList<>();
    private List<TagDto> tags = new ArrayList<>();
    /**
     * pet status in the store
    */
    private StatusEnum status = null;

    public boolean isEmpty() {
        return getId() == null
                && getCategory() == null
                && getTags() == null
                && getStatus() == null
        ;
    }

    public PetDto putAll(PetDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getCategory() != null) setCategory(o.getCategory());
        if (o.getName() != null) setName(o.getName());
        if (o.getPhotoUrls() != null) setPhotoUrls(o.getPhotoUrls());
        if (o.getTags() != null) setTags(o.getTags());
        if (o.getStatus() != null) setStatus(o.getStatus());
        return this;
    }

    public PetDto removeWhereEqual(PetDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getCategory(), o.getCategory())) setCategory(null);
        if (Objects.equals(getTags(), o.getTags())) setTags(null);
        if (Objects.equals(getStatus(), o.getStatus())) setStatus(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCategory() != null) {
            fields.addAll(getCategory().missingRequiredFields(prefix + ".category"));
        }
        if (getName() == null) fields.add(prefix + "name");
        if (getPhotoUrls() == null) fields.add(prefix + "photoUrls");
        return fields;
    }

}