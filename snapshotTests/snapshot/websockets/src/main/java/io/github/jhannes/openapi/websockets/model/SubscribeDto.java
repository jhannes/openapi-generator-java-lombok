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
        return this;
    }

    public SubscribeDto putAll(WebSocketRequestDto o) {
        if (o instanceof SubscribeDto same) putAll(same);
        return this;
    }

    public SubscribeDto removeWhereEqual(SubscribeDto o) {
        return this;
    }

    public SubscribeDto removeWhereEqual(WebSocketRequestDto o) {
        if (o instanceof SubscribeDto same) removeWhereEqual(same);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getRequest() == null) fields.add(prefix + "request");
        return fields;
    }

}