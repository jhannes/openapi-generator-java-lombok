package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public final class SubscribeRequestDto implements RequestToServerDto {

    private String request = "SubscribeRequest";
    private UUID clientId;

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public SubscribeRequestDto putAll(SubscribeRequestDto o) {
        if (o.getClientId() != null) setClientId(o.getClientId());
        return this;
    }

    public SubscribeRequestDto removeWhereEqual(SubscribeRequestDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getRequest() == null) fields.add(prefix + "request");
        if (getClientId() == null) fields.add(prefix + "clientId");
        return fields;
    }

}