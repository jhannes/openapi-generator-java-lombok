package io.github.jhannes.openapi.petstore.model;

import java.time.OffsetDateTime;
import lombok.*;

@Data
public final class OrderDto {

    /**
     * Order Status
     */
    @Getter
    @RequiredArgsConstructor
    public enum StatusEnum {
        placed("placed"),
        approved("approved"),
        delivered("delivered");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    private Long id = null;
    private Long petId = null;
    private Integer quantity = null;
    private OffsetDateTime shipDate = null;
    /**
     * Order Status
    */
    private StatusEnum status = null;
    private Boolean complete = null;

}