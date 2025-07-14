package io.github.jhannes.openapi.openid_configuration.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Data;

@Data
public final class JwtPayloadDto {

    /**
     * Issuer - the URI for the login provider
    */
    private String iss;
    /**
     * Subject - the unique identifier for the logged in user
    */
    private String sub;
    /**
     * Expiry - the unix timestamp after which the JWT should be rejected
    */
    private Long exp;
    /**
     * Audience - the client_id that the JWT was issued to
    */
    private String aud;
    /**
     * The name of the logged in user
    */
    private String name = null;
    /**
     * The email of the logged in user
    */
    private String email = null;
    /**
     * The unique identifier of the organization that the user has selected
    */
    private String orgId = null;
    /**
     * The name of the organization that the user has selected
    */
    private String org = null;
    /**
     * For JWT from ID-porten, contains national identity number
    */
    private String pid = null;

    public boolean hasNoOptionalProperties() {
        return getName() == null
                && getEmail() == null
                && getOrgId() == null
                && getOrg() == null
                && getPid() == null
        ;
    }

    public JwtPayloadDto putAll(JwtPayloadDto o) {
        o.copyToJwtPayload(this);
        return this;
    }

    public JwtPayloadDto removeWhereEqual(JwtPayloadDto o) {
        if (Objects.equals(getName(), o.getName())) setName(null);
        if (Objects.equals(getEmail(), o.getEmail())) setEmail(null);
        if (Objects.equals(getOrgId(), o.getOrgId())) setOrgId(null);
        if (Objects.equals(getOrg(), o.getOrg())) setOrg(null);
        if (Objects.equals(getPid(), o.getPid())) setPid(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getIss() == null) fields.add(prefix + "iss");
        if (getSub() == null) fields.add(prefix + "sub");
        if (getExp() == null) fields.add(prefix + "exp");
        if (getAud() == null) fields.add(prefix + "aud");
        return fields;
    }

    public void copyToJwtPayload(JwtPayloadDto o) {
        if (getIss() != null) o.setIss(getIss());
        if (getSub() != null) o.setSub(getSub());
        if (getExp() != null) o.setExp(getExp());
        if (getAud() != null) o.setAud(getAud());
        if (getName() != null) o.setName(getName());
        if (getEmail() != null) o.setEmail(getEmail());
        if (getOrgId() != null) o.setOrgId(getOrgId());
        if (getOrg() != null) o.setOrg(getOrg());
        if (getPid() != null) o.setPid(getPid());
    }
}