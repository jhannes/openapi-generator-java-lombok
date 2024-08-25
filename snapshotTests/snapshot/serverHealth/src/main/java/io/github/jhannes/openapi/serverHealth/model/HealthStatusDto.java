package io.github.jhannes.openapi.serverHealth.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum HealthStatusDto {
    UP("UP"),
    DOWN("DOWN");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}