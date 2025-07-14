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
        o.copyToSubscribeRequest(this);
        return this;
    }

    public SubscribeRequestDto putAll(MessageToServerDto o) {
        o.copyToSubscribeRequest(this);
        return this;
    }

    public SubscribeRequestDto removeWhereEqual(SubscribeRequestDto o) {
        o.removeWhereEqualFromSubscribeRequest(this);
        return this;
    }

    public SubscribeRequestDto removeWhereEqual(MessageToServerDto o) {
        o.removeWhereEqualFromSubscribeRequest(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getRequest() == null) fields.add(prefix + "request");
        if (getClientId() == null) fields.add(prefix + "clientId");
        return fields;
    }

    public void copyToSubscribeRequest(SubscribeRequestDto o) {
        if (getClientId() != null) o.setClientId(getClientId());
    }

    public void removeWhereEqualFromSubscribeRequest(SubscribeRequestDto o) {
    }
}