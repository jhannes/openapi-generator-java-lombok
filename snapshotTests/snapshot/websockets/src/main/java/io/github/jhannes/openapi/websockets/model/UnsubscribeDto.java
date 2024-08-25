package io.github.jhannes.openapi.websockets.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class UnsubscribeDto {

    private String request = "Unsubscribe";

    public boolean isEmpty() {
        return false;
    }

    public UnsubscribeDto putAll(UnsubscribeDto o) {
        if (o.getRequest() != null) setRequest(o.getRequest());
        return this;
    }

    public UnsubscribeDto removeWhereEqual(UnsubscribeDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getRequest() == null) fields.add(prefix + "request");
        return fields;
    }

}