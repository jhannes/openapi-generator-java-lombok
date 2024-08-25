package io.github.jhannes.openapi.petstore.api;

import io.github.jhannes.openapi.petstore.model.*;

import lombok.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.time.*;
import java.util.*;
import java.util.function.*;

import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;

public interface StoreApi {
    /**
     * Delete purchase order by ID
     * For valid response try integer IDs with value &lt; 1000. Anything above 1000 or nonintegers will generate API errors
     * @param orderId ID of the order that needs to be deleted (path) (required)
     */
    void deleteOrder(
            String orderId
    ) throws IOException;
    /**
     * Returns pet inventories by status
     * Returns a map of status codes to quantities
     * @param effectiveDateTime  (query) (optional)
     * @return Map&lt;String, Integer&gt;
     */
    Map<String, Integer> getInventory(
            Optional<OffsetDateTime> effectiveDateTime
    ) throws IOException;

    @Data
    class GetInventoryQuery {
        private OffsetDateTime effectiveDateTime;

        public String toUrlEncoded() {
            List<String> parameters = new ArrayList<>();
            if (effectiveDateTime != null) parameters.add("effectiveDateTime=" + encode(effectiveDateTime.toString(), UTF_8));
            return String.join("&", parameters);
        }
    }
    /**
     * Find purchase order by ID
     * For valid response try integer IDs with value &lt;&#x3D; 5 or &gt; 10. Other values will generated exceptions
     * @param orderId ID of pet that needs to be fetched (path) (required)
     * @return OrderDto
     */
    OrderDto getOrderById(
            String orderId
    ) throws IOException;
    /**
     * Place an order for a pet
     * @param OrderDto order placed for purchasing the pet (optional)
     * @return OrderDto
     */
    OrderDto placeOrder(
            Optional<OrderDto> OrderDto
    ) throws IOException;
}
