package io.github.jhannes.openapi.readOnly.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.*;

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

}