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

    public boolean hasNoOptionalProperties() {
        return getKty() == null
                && getUse() == null
                && getE() == null
                && getN() == null
        ;
    }

    public JwksKeyDto putAll(JwksKeyDto o) {
        o.copyToJwksKey(this);
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

    public void copyToJwksKey(JwksKeyDto o) {
        if (getKty() != null) o.setKty(getKty());
        if (getUse() != null) o.setUse(getUse());
        if (getKid() != null) o.setKid(getKid());
        if (getX5c() != null) o.setX5c(getX5c());
        if (getE() != null) o.setE(getE());
        if (getN() != null) o.setN(getN());
    }
}