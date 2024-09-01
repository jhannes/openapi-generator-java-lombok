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

    public boolean empty() {
        return getId() == null
        ;
    }

    public CaseWorkerDto putAll(CaseWorkerDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getFullName() != null) setFullName(o.getFullName());
        if (o.getEmail() != null) setEmail(o.getEmail());
        if (o.getRole() != null) setRole(o.getRole());
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

}