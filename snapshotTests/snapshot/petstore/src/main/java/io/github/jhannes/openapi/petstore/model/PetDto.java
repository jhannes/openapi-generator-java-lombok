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

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getCategory() == null
                && getTags() == null
                && getStatus() == null
        ;
    }

    public PetDto putAll(PetDto o) {
        o.copyToPet(this);
        return this;
    }

    public PetDto removeWhereEqual(PetDto o) {
        o.removeWhereEqualFromPet(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCategory() != null) {
            fields.addAll(getCategory().missingRequiredFields(prefix + "category."));
        }
        if (getName() == null) fields.add(prefix + "name");
        if (getPhotoUrls() == null) fields.add(prefix + "photoUrls");
        if (getTags() != null) {
            for (int i = 0; i < getTags().size(); i++) {
                fields.addAll(getTags().get(i).missingRequiredFields(prefix + "tags[" + i + "]."));
            }
        }
        return fields;
    }

    public void copyToPet(PetDto o) {
        if (getId() != null) o.setId(getId());
        if (getCategory() != null) o.setCategory(getCategory());
        if (getName() != null) o.setName(getName());
        if (getPhotoUrls() != null) o.setPhotoUrls(getPhotoUrls());
        if (getTags() != null) o.setTags(getTags());
        if (getStatus() != null) o.setStatus(getStatus());
    }

    public void removeWhereEqualFromPet(PetDto o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getCategory(), o.getCategory())) o.setCategory(null);
        if (Objects.equals(getTags(), o.getTags())) o.setTags(null);
        if (Objects.equals(getStatus(), o.getStatus())) o.setStatus(null);
    }
}