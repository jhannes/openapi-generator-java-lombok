package io.github.jhannes.openapi.websockets.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class SubscribeDto implements WebSocketRequestDto {

    private String request = "Subscribe";

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public SubscribeDto putAll(SubscribeDto o) {
        o.copyToSubscribe(this);
        return this;
    }

    public SubscribeDto putAll(WebSocketRequestDto o) {
        o.copyToSubscribe(this);
        return this;
    }

    public SubscribeDto removeWhereEqual(SubscribeDto o) {
        o.removeWhereEqualFromSubscribe(this);
        return this;
    }

    public SubscribeDto removeWhereEqual(WebSocketRequestDto o) {
        o.removeWhereEqualFromSubscribe(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getRequest() == null) fields.add(prefix + "request");
        return fields;
    }

    public void copyToSubscribe(SubscribeDto o) {
    }

    public void removeWhereEqualFromSubscribe(SubscribeDto o) {
    }
}