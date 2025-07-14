package io.github.jhannes.openapi.infectionTracker.model;

import io.github.jhannes.openapi.infectionTracker.model.UserRoleDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.Data;

@Data
public final class CaseWorkerDto {

    private UUID id = null;
    private String fullName;
    private String email;
    private UserRoleDto role;

    public boolean hasNoOptionalProperties() {
        return getId() == null
        ;
    }

    public CaseWorkerDto putAll(CaseWorkerDto o) {
        o.copyToCaseWorker(this);
        return this;
    }

    public CaseWorkerDto removeWhereEqual(CaseWorkerDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getFullName() == null) fields.add(prefix + "fullName");
        if (getEmail() == null) fields.add(prefix + "email");
        if (getRole() == null) fields.add(prefix + "role");
        return fields;
    }

    public void copyToCaseWorker(CaseWorkerDto o) {
        if (getId() != null) o.setId(getId());
        if (getFullName() != null) o.setFullName(getFullName());
        if (getEmail() != null) o.setEmail(getEmail());
        if (getRole() != null) o.setRole(getRole());
    }
}