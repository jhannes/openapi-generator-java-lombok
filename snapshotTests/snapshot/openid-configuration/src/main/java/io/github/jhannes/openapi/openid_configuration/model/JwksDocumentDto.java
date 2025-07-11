package io.github.jhannes.openapi.openid_configuration.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public final class JwksDocumentDto {

    private List<JwksKeyDto> keys = new ArrayList<>();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public JwksDocumentDto putAll(JwksDocumentDto o) {
        if (o.getKeys() != null) setKeys(o.getKeys());
        return this;
    }

    public JwksDocumentDto removeWhereEqual(JwksDocumentDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getKeys() != null) {
            for (int i = 0; i < getKeys().size(); i++) {
                fields.addAll(getKeys().get(i).missingRequiredFields(prefix + "keys[" + i + "]."));
            }
        } else {
            fields.add(prefix + "keys");
        }
        return fields;
    }

}