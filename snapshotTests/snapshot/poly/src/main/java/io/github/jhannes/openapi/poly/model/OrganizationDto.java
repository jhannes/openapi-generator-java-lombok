package io.github.jhannes.openapi.poly.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import lombok.Data;

@Data
public final class OrganizationDto implements AnyPartyDto {

    private UUID id = null;
    private String type;
    private String name;
    private String organizationId = null;
    private URI url = null;
    private String email = null;
    private Set<String> emailDomains = new HashSet<>();
    private String phone = null;

    public boolean hasNoOptionalProperties() {
        return getId() == null
                && getOrganizationId() == null
                && getUrl() == null
                && getEmail() == null
                && getEmailDomains() == null
                && getPhone() == null
        ;
    }

    public OrganizationDto putAll(OrganizationDto o) {
        o.copyToOrganization(this);
        return this;
    }

    public OrganizationDto putAll(AnyPartyDto o) {
        o.copyToOrganization(this);
        return this;
    }

    public OrganizationDto removeWhereEqual(OrganizationDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getOrganizationId(), o.getOrganizationId())) setOrganizationId(null);
        if (Objects.equals(getUrl(), o.getUrl())) setUrl(null);
        if (Objects.equals(getEmail(), o.getEmail())) setEmail(null);
        if (Objects.equals(getEmailDomains(), o.getEmailDomains())) setEmailDomains(null);
        if (Objects.equals(getPhone(), o.getPhone())) setPhone(null);
        return this;
    }

    public OrganizationDto removeWhereEqual(AnyPartyDto o) {
        if (o instanceof OrganizationDto same) removeWhereEqual(same);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getName() == null) fields.add(prefix + "name");
        return fields;
    }

    public void copyToOrganization(OrganizationDto o) {
        if (getId() != null) o.setId(getId());
        if (getName() != null) o.setName(getName());
        if (getOrganizationId() != null) o.setOrganizationId(getOrganizationId());
        if (getUrl() != null) o.setUrl(getUrl());
        if (getEmail() != null) o.setEmail(getEmail());
        if (getEmailDomains() != null) o.setEmailDomains(getEmailDomains());
        if (getPhone() != null) o.setPhone(getPhone());
    }
}