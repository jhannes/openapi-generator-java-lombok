package io.github.jhannes.openapi.infectionTracker.model;

import lombok.*;

@Getter
@RequiredArgsConstructor
public enum UserRoleDto {
    ADMINISTRATOR("administrator"),
    INTERVIEWER("interviewer"),
    FOLLOWUP("followup");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}