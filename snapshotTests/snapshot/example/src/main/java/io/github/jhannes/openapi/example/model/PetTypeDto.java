package io.github.jhannes.openapi.example.model;

import lombok.*;

@Getter
@RequiredArgsConstructor
public enum PetTypeDto {
    cat("cat"),
    dog("dog"),
    bird("bird");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}