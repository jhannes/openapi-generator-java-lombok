package io.github.jhannes.openapi.petstore.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
public final class PetDto {

    /**
     * pet status in the store
     */
    @Getter
    @RequiredArgsConstructor
    public enum StatusEnum {
        available("available"),
        pending("pending"),
        sold("sold");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    private Long id = null;
    private CategoryDto category = null;
    private String name;
    private List<String> photoUrls = new ArrayList<>();
    private List<TagDto> tags = new ArrayList<>();
    /**
     * pet status in the store
    */
    private StatusEnum status = null;

}