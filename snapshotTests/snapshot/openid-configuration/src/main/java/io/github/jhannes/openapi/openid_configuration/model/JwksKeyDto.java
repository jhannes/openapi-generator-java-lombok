package io.github.jhannes.openapi.openid_configuration.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class JwksKeyDto {

    private String kty = null;
    private String use = null;
    private String kid;
    private String x5c;
    private String e = null;
    private String n = null;

    public boolean empty() {
        return getKty() == null
                && getUse() == null
                && getE() == null
                && getN() == null
        ;
    }

    public JwksKeyDto putAll(JwksKeyDto o) {
        if (o.getKty() != null) setKty(o.getKty());
        if (o.getUse() != null) setUse(o.getUse());
        if (o.getKid() != null) setKid(o.getKid());
        if (o.getX5c() != null) setX5c(o.getX5c());
        if (o.getE() != null) setE(o.getE());
        if (o.getN() != null) setN(o.getN());
        return this;
    }

    public JwksKeyDto removeWhereEqual(JwksKeyDto o) {
        if (Objects.equals(getKty(), o.getKty())) setKty(null);
        if (Objects.equals(getUse(), o.getUse())) setUse(null);
        if (Objects.equals(getE(), o.getE())) setE(null);
        if (Objects.equals(getN(), o.getN())) setN(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getKid() == null) fields.add(prefix + "kid");
        if (getX5c() == null) fields.add(prefix + "x5c");
        return fields;
    }

}