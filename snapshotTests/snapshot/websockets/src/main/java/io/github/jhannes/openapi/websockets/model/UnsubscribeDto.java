package io.github.jhannes.openapi.websockets.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class UnsubscribeDto {

    private String request = "Unsubscribe";

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public UnsubscribeDto putAll(UnsubscribeDto o) {
        o.copyToUnsubscribe(this);
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

    public void copyToUnsubscribe(UnsubscribeDto o) {
        if (getRequest() != null) o.setRequest(getRequest());
    }
}