package io.github.jhannes.openapi.openid_configuration.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.*;

@Data
public final class UserinfoDto {

    /**
     * Subject identifier
    */
    private String sub;
    private String name = null;
    private Object email = null;

    public boolean isEmpty() {
        return getName() == null
                && getEmail() == null
        ;
    }

    public UserinfoDto putAll(UserinfoDto o) {
        if (o.getSub() != null) setSub(o.getSub());
        if (o.getName() != null) setName(o.getName());
        if (o.getEmail() != null) setEmail(o.getEmail());
        return this;
    }

    public UserinfoDto removeWhereEqual(UserinfoDto o) {
        if (Objects.equals(getName(), o.getName())) setName(null);
        if (Objects.equals(getEmail(), o.getEmail())) setEmail(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getSub() == null) fields.add(prefix + "sub");
        return fields;
    }

}