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

    public boolean empty() {
        return getId() == null
                && getName() == null
                && getBirth_date() == null
                && getCreated_at() == null
                && getComments() == null
                && getStatus() == null
        ;
    }

    public PetDto putAll(PetDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getPet_type() != null) setPet_type(o.getPet_type());
        if (o.getName() != null) setName(o.getName());
        if (o.getBirth_date() != null) setBirth_date(o.getBirth_date());
        if (o.getCreated_at() != null) setCreated_at(o.getCreated_at());
        if (o.getComments() != null) setComments(o.getComments());
        if (o.getStatus() != null) setStatus(o.getStatus());
        return this;
    }

    public PetDto removeWhereEqual(PetDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getName(), o.getName())) setName(null);
        if (Objects.equals(getBirth_date(), o.getBirth_date())) setBirth_date(null);
        if (Objects.equals(getCreated_at(), o.getCreated_at())) setCreated_at(null);
        if (Objects.equals(getComments(), o.getComments())) setComments(null);
        if (Objects.equals(getStatus(), o.getStatus())) setStatus(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getPet_type() == null) fields.add(prefix + "petType");
        return fields;
    }

}