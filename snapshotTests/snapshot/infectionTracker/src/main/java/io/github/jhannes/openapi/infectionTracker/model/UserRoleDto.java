package io.github.jhannes.openapi.infectionTracker.model;

import lombok.*;

@Getter
@RequiredArgsConstructor
public enum UserRoleDto {
    administrator("administrator"),
    interviewer("interviewer"),
    followup("followup");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}