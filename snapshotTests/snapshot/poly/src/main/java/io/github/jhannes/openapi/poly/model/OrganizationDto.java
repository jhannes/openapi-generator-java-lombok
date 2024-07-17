package io.github.jhannes.openapi.poly.model;

import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import lombok.*;

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

}