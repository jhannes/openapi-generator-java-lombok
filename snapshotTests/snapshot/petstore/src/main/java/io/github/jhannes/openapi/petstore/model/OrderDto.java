package io.github.jhannes.openapi.petstore.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
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
        o.copyToOrder(this);
        return this;
    }

    public OrderDto removeWhereEqual(OrderDto o) {
        o.removeWhereEqualFromOrder(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToOrder(OrderDto o) {
        if (getId() != null) o.setId(getId());
        if (getPetId() != null) o.setPetId(getPetId());
        if (getQuantity() != null) o.setQuantity(getQuantity());
        if (getShipDate() != null) o.setShipDate(getShipDate());
        if (getStatus() != null) o.setStatus(getStatus());
        if (getComplete() != null) o.setComplete(getComplete());
    }

    public void removeWhereEqualFromOrder(OrderDto o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getPetId(), o.getPetId())) o.setPetId(null);
        if (Objects.equals(getQuantity(), o.getQuantity())) o.setQuantity(null);
        if (Objects.equals(getShipDate(), o.getShipDate())) o.setShipDate(null);
        if (Objects.equals(getStatus(), o.getStatus())) o.setStatus(null);
        if (Objects.equals(getComplete(), o.getComplete())) o.setComplete(null);
    }
}