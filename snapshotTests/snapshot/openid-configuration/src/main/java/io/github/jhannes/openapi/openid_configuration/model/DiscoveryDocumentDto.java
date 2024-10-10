package io.github.jhannes.openapi.openid_configuration.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
public final class DiscoveryDocumentDto {

    @Getter
    @RequiredArgsConstructor
    public enum ResponseModesSupportedEnum {
        query("query"),
        fragment("fragment"),
        form_post("form_post");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    @Getter
    @RequiredArgsConstructor
    public enum SubjectTypesSupportedEnum {
        pairwise("pairwise"),
        _public("public");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    @Getter
    @RequiredArgsConstructor
    public enum CodeChallengeMethodsSupportedEnum {
        S256("S256"),
        plain("plain");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    @Getter
    @RequiredArgsConstructor
    public enum IdTokenSigningAlgValuesSupportedEnum {
        RS256("RS256");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    private String issuer;
    private URI authorization_endpoint;
    private URI token_endpoint;
    private URI userinfo_endpoint = null;
    private URI end_session_endpoint = null;
    private URI jwks_uri = null;
    private Set<GrantTypeDto> grant_types_supported = new LinkedHashSet<>();
    private Set<Object> scopes_supported = new LinkedHashSet<>();
    private Set<Object> claims_supported = new LinkedHashSet<>();
    private Set<ResponseTypeDto> response_types_supported = new LinkedHashSet<>();
    private Set<ResponseModesSupportedEnum> response_modes_supported = new LinkedHashSet<>();
    private Set<SubjectTypesSupportedEnum> subject_types_supported = new LinkedHashSet<>();
    private Set<CodeChallengeMethodsSupportedEnum> code_challenge_methods_supported = new LinkedHashSet<>();
    private List<IdTokenSigningAlgValuesSupportedEnum> id_token_signing_alg_values_supported = new ArrayList<>();
    private String x_sso_frame = null;

    public boolean hasNoOptionalProperties() {
        return getUserinfo_endpoint() == null
                && getEnd_session_endpoint() == null
                && getJwks_uri() == null
                && getGrant_types_supported() == null
                && getScopes_supported() == null
                && getClaims_supported() == null
                && getResponse_modes_supported() == null
                && getSubject_types_supported() == null
                && getCode_challenge_methods_supported() == null
                && getId_token_signing_alg_values_supported() == null
                && getX_sso_frame() == null
        ;
    }

    public DiscoveryDocumentDto putAll(DiscoveryDocumentDto o) {
        if (o.getIssuer() != null) setIssuer(o.getIssuer());
        if (o.getAuthorization_endpoint() != null) setAuthorization_endpoint(o.getAuthorization_endpoint());
        if (o.getToken_endpoint() != null) setToken_endpoint(o.getToken_endpoint());
        if (o.getUserinfo_endpoint() != null) setUserinfo_endpoint(o.getUserinfo_endpoint());
        if (o.getEnd_session_endpoint() != null) setEnd_session_endpoint(o.getEnd_session_endpoint());
        if (o.getJwks_uri() != null) setJwks_uri(o.getJwks_uri());
        if (o.getGrant_types_supported() != null) setGrant_types_supported(o.getGrant_types_supported());
        if (o.getScopes_supported() != null) setScopes_supported(o.getScopes_supported());
        if (o.getClaims_supported() != null) setClaims_supported(o.getClaims_supported());
        if (o.getResponse_types_supported() != null) setResponse_types_supported(o.getResponse_types_supported());
        if (o.getResponse_modes_supported() != null) setResponse_modes_supported(o.getResponse_modes_supported());
        if (o.getSubject_types_supported() != null) setSubject_types_supported(o.getSubject_types_supported());
        if (o.getCode_challenge_methods_supported() != null) setCode_challenge_methods_supported(o.getCode_challenge_methods_supported());
        if (o.getId_token_signing_alg_values_supported() != null) setId_token_signing_alg_values_supported(o.getId_token_signing_alg_values_supported());
        if (o.getX_sso_frame() != null) setX_sso_frame(o.getX_sso_frame());
        return this;
    }

    public DiscoveryDocumentDto removeWhereEqual(DiscoveryDocumentDto o) {
        if (Objects.equals(getUserinfo_endpoint(), o.getUserinfo_endpoint())) setUserinfo_endpoint(null);
        if (Objects.equals(getEnd_session_endpoint(), o.getEnd_session_endpoint())) setEnd_session_endpoint(null);
        if (Objects.equals(getJwks_uri(), o.getJwks_uri())) setJwks_uri(null);
        if (Objects.equals(getGrant_types_supported(), o.getGrant_types_supported())) setGrant_types_supported(null);
        if (Objects.equals(getScopes_supported(), o.getScopes_supported())) setScopes_supported(null);
        if (Objects.equals(getClaims_supported(), o.getClaims_supported())) setClaims_supported(null);
        if (Objects.equals(getResponse_modes_supported(), o.getResponse_modes_supported())) setResponse_modes_supported(null);
        if (Objects.equals(getSubject_types_supported(), o.getSubject_types_supported())) setSubject_types_supported(null);
        if (Objects.equals(getCode_challenge_methods_supported(), o.getCode_challenge_methods_supported())) setCode_challenge_methods_supported(null);
        if (Objects.equals(getId_token_signing_alg_values_supported(), o.getId_token_signing_alg_values_supported())) setId_token_signing_alg_values_supported(null);
        if (Objects.equals(getX_sso_frame(), o.getX_sso_frame())) setX_sso_frame(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getIssuer() == null) fields.add(prefix + "issuer");
        if (getAuthorization_endpoint() == null) fields.add(prefix + "authorizationEndpoint");
        if (getToken_endpoint() == null) fields.add(prefix + "tokenEndpoint");
        if (getResponse_types_supported() == null) fields.add(prefix + "responseTypesSupported");
        return fields;
    }

}