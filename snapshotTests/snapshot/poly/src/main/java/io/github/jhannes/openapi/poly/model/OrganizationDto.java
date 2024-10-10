package io.github.jhannes.openapi.poly.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
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
    private Set<String> emailDomains = new LinkedHashSet<>();
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
        if (o.getId() != null) setId(o.getId());
        if (o.getType() != null) setType(o.getType());
        if (o.getName() != null) setName(o.getName());
        if (o.getOrganizationId() != null) setOrganizationId(o.getOrganizationId());
        if (o.getUrl() != null) setUrl(o.getUrl());
        if (o.getEmail() != null) setEmail(o.getEmail());
        if (o.getEmailDomains() != null) setEmailDomains(o.getEmailDomains());
        if (o.getPhone() != null) setPhone(o.getPhone());
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

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getName() == null) fields.add(prefix + "name");
        return fields;
    }

}