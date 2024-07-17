package io.github.jhannes.openapi.infectionTracker.model;

import io.github.jhannes.openapi.infectionTracker.model.UserRoleDto;
import java.util.UUID;
import lombok.*;

@Data
public final class CaseWorkerDto {

    private UUID id = null;
    private String fullName;
    private String email;
    private UserRoleDto role;

}