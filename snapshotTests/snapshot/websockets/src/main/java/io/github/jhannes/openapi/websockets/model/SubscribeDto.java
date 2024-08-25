package io.github.jhannes.openapi.websockets.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

@Data
public final class SubscribeDto implements WebSocketRequestDto {

    private String request = "Subscribe";

    public boolean isEmpty() {
        return false
        ;
    }

    public SubscribeDto putAll(SubscribeDto o) {
        if (o.getRequest() != null) setRequest(o.getRequest());
        return this;
    }

    public SubscribeDto removeWhereEqual(SubscribeDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getRequest() == null) fields.add(prefix + "request");
        return fields;
    }

}