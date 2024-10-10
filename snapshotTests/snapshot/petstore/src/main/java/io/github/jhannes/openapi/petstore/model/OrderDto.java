package io.github.jhannes.openapi.petstore.model;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

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

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getPetId() == null
                && getQuantity() == null
                && getShipDate() == null
                && getStatus() == null
                && getComplete() == null
        ;
    }

    public OrderDto putAll(OrderDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getPetId() != null) setPetId(o.getPetId());
        if (o.getQuantity() != null) setQuantity(o.getQuantity());
        if (o.getShipDate() != null) setShipDate(o.getShipDate());
        if (o.getStatus() != null) setStatus(o.getStatus());
        if (o.getComplete() != null) setComplete(o.getComplete());
        return this;
    }

    public OrderDto removeWhereEqual(OrderDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getPetId(), o.getPetId())) setPetId(null);
        if (Objects.equals(getQuantity(), o.getQuantity())) setQuantity(null);
        if (Objects.equals(getShipDate(), o.getShipDate())) setShipDate(null);
        if (Objects.equals(getStatus(), o.getStatus())) setStatus(null);
        if (Objects.equals(getComplete(), o.getComplete())) setComplete(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return List.of();
    }

}