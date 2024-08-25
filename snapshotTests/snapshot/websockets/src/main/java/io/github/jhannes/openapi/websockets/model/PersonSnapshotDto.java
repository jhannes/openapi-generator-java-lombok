package io.github.jhannes.openapi.websockets.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.Data;

@Data
public final class PersonSnapshotDto implements ChangeTrackedInterface, PersonInterface {

    private OffsetDateTime createdAt;
    private String createdBy;
    private OffsetDateTime updatedAt = null;
    private String updatedBy = null;
    private String email = null;
    private UUID id = null;
    private String type = null;
    private PersonNameDto name = null;
    private String phone = null;
    private LocalDate birthDate = null;
    private GenderEnum gender = null;
    private String extra = null;

    public boolean isEmpty() {
        return isChangeTrackedEmpty()
                && isPersonEmpty()
                && getExtra() == null
        ;
    }

    public PersonSnapshotDto putAll(PersonSnapshotDto o) {
        o.copyToPersonSnapshot(this);
        return this;
    }

    @Override
    public PersonSnapshotDto putAll(ChangeTrackedInterface o) {
        o.copyToPersonSnapshot(this);
        return this;
    }

    @Override
    public PersonSnapshotDto putAll(PersonInterface o) {
        o.copyToPersonSnapshot(this);
        return this;
    }

    @Override
    public PersonSnapshotDto putAll(RecipientInterface o) {
        o.copyToPersonSnapshot(this);
        return this;
    }

    public PersonSnapshotDto removeWhereEqual(PersonSnapshotDto o) {
        o.removeWhereEqualFromPersonSnapshot(this);
        return this;
    }

    @Override
    public PersonSnapshotDto removeWhereEqual(ChangeTrackedInterface o) {
        o.removeWhereEqualFromPersonSnapshot(this);
        return this;
    }

    @Override
    public PersonSnapshotDto removeWhereEqual(PersonInterface o) {
        o.removeWhereEqualFromPersonSnapshot(this);
        return this;
    }

    @Override
    public PersonSnapshotDto removeWhereEqual(RecipientInterface o) {
        o.removeWhereEqualFromPersonSnapshot(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getCreatedAt() == null) fields.add(prefix + "createdAt");
        if (getCreatedBy() == null) fields.add(prefix + "createdBy");
        if (getName() != null) {
            fields.addAll(getName().missingRequiredFields(prefix + ".name"));
        }
        return fields;
    }

    @Override
    public void copyToPersonSnapshot(PersonSnapshotDto o) {
        copyToChangeTrackedInterface(o);
        copyToPersonInterface(o);
        if (getExtra() != null) o.setExtra(getExtra());
    }

    @Override
    public void removeWhereEqualFromPersonSnapshot(PersonSnapshotDto o) {
        removeWhereEqualFromChangeTrackedInterface(o);
        removeWhereEqualFromPersonInterface(o);
        if (Objects.equals(getExtra(), o.getExtra())) o.setExtra(null);
    }
}