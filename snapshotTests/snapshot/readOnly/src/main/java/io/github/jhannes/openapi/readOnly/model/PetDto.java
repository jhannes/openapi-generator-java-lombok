package io.github.jhannes.openapi.readOnly.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
public final class PetDto {

    @Getter
    @RequiredArgsConstructor
    public enum PetTypeEnum {
        Cat("Cat"),
        Dog("Dog");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    @Getter
    @RequiredArgsConstructor
    public enum StatusEnum {
        Pending("Pending"),
        Available("Available"),
        Sold("Sold");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    private UUID id = null;
    private PetTypeEnum pet_type;
    private String name = null;
    private LocalDate birth_date = null;
    private OffsetDateTime created_at = null;
    private List<CommentDto> comments = new ArrayList<>();
    private StatusEnum status = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getName() == null
                && getBirth_date() == null
                && getCreated_at() == null
                && getComments() == null
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
        if (getPet_type() == null) fields.add(prefix + "pet_type");
        if (getComments() != null) {
            for (int i = 0; i < getComments().size(); i++) {
                fields.addAll(getComments().get(i).missingRequiredFields(prefix + "comments[" + i + "]."));
            }
        }
        return fields;
    }

    public void copyToPet(PetDto o) {
        if (getId() != null) o.setId(getId());
        if (getPet_type() != null) o.setPet_type(getPet_type());
        if (getName() != null) o.setName(getName());
        if (getBirth_date() != null) o.setBirth_date(getBirth_date());
        if (getCreated_at() != null) o.setCreated_at(getCreated_at());
        if (getComments() != null) o.setComments(getComments());
        if (getStatus() != null) o.setStatus(getStatus());
    }

    public void removeWhereEqualFromPet(PetDto o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getName(), o.getName())) o.setName(null);
        if (Objects.equals(getBirth_date(), o.getBirth_date())) o.setBirth_date(null);
        if (Objects.equals(getCreated_at(), o.getCreated_at())) o.setCreated_at(null);
        if (Objects.equals(getComments(), o.getComments())) o.setComments(null);
        if (Objects.equals(getStatus(), o.getStatus())) o.setStatus(null);
    }
}