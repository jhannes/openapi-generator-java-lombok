package io.github.jhannes.openapi.example.model;

import lombok.*;

@Getter
@RequiredArgsConstructor
public enum PetTypeDto {
    CAT("cat"),
    DOG("dog"),
    BIRD("bird");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}