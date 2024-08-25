package io.github.jhannes.openapi.openid_configuration.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public final class JwtPayloadDto extends HashMap<String, List> {

    /**
     * Issuer - the URI for the login provider
    */
    private String iss;
    /**
     * Subject - the unique identifier for the logged in user
    */
    private String sub;
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

    public boolean isEmpty() {
        return super.isEmpty()
                && getName() == null
                && getEmail() == null
                && getOrgId() == null
                && getOrg() == null
                && getPid() == null
        ;
    }

    public JwtPayloadDto putAll(JwtPayloadDto o) {
        super.putAll(o);
        if (o.getIss() != null) setIss(o.getIss());
        if (o.getSub() != null) setSub(o.getSub());
        if (o.getAud() != null) setAud(o.getAud());
        if (o.getName() != null) setName(o.getName());
        if (o.getEmail() != null) setEmail(o.getEmail());
        if (o.getOrgId() != null) setOrgId(o.getOrgId());
        if (o.getOrg() != null) setOrg(o.getOrg());
        if (o.getPid() != null) setPid(o.getPid());
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
        if (getAud() == null) fields.add(prefix + "aud");
        return fields;
    }

}