package io.github.jhannes.openapi.openid_configuration.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
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
    private Set<GrantTypeDto> grant_types_supported = new HashSet<>();
    private Set<String> scopes_supported = new HashSet<>();
    private Set<String> claims_supported = new HashSet<>();
    private Set<ResponseTypeDto> response_types_supported = new HashSet<>();
    private Set<ResponseModesSupportedEnum> response_modes_supported = new HashSet<>();
    private Set<SubjectTypesSupportedEnum> subject_types_supported = new HashSet<>();
    private Set<CodeChallengeMethodsSupportedEnum> code_challenge_methods_supported = new HashSet<>();
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
        o.copyToDiscoveryDocument(this);
        return this;
    }

    public DiscoveryDocumentDto removeWhereEqual(DiscoveryDocumentDto o) {
        o.removeWhereEqualFromDiscoveryDocument(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getIssuer() == null) fields.add(prefix + "issuer");
        if (getAuthorization_endpoint() == null) fields.add(prefix + "authorization_endpoint");
        if (getToken_endpoint() == null) fields.add(prefix + "token_endpoint");
        if (getResponse_types_supported() == null) fields.add(prefix + "response_types_supported");
        return fields;
    }

    public void copyToDiscoveryDocument(DiscoveryDocumentDto o) {
        if (getIssuer() != null) o.setIssuer(getIssuer());
        if (getAuthorization_endpoint() != null) o.setAuthorization_endpoint(getAuthorization_endpoint());
        if (getToken_endpoint() != null) o.setToken_endpoint(getToken_endpoint());
        if (getUserinfo_endpoint() != null) o.setUserinfo_endpoint(getUserinfo_endpoint());
        if (getEnd_session_endpoint() != null) o.setEnd_session_endpoint(getEnd_session_endpoint());
        if (getJwks_uri() != null) o.setJwks_uri(getJwks_uri());
        if (getGrant_types_supported() != null) o.setGrant_types_supported(getGrant_types_supported());
        if (getScopes_supported() != null) o.setScopes_supported(getScopes_supported());
        if (getClaims_supported() != null) o.setClaims_supported(getClaims_supported());
        if (getResponse_types_supported() != null) o.setResponse_types_supported(getResponse_types_supported());
        if (getResponse_modes_supported() != null) o.setResponse_modes_supported(getResponse_modes_supported());
        if (getSubject_types_supported() != null) o.setSubject_types_supported(getSubject_types_supported());
        if (getCode_challenge_methods_supported() != null) o.setCode_challenge_methods_supported(getCode_challenge_methods_supported());
        if (getId_token_signing_alg_values_supported() != null) o.setId_token_signing_alg_values_supported(getId_token_signing_alg_values_supported());
        if (getX_sso_frame() != null) o.setX_sso_frame(getX_sso_frame());
    }

    public void removeWhereEqualFromDiscoveryDocument(DiscoveryDocumentDto o) {
        if (Objects.equals(getUserinfo_endpoint(), o.getUserinfo_endpoint())) o.setUserinfo_endpoint(null);
        if (Objects.equals(getEnd_session_endpoint(), o.getEnd_session_endpoint())) o.setEnd_session_endpoint(null);
        if (Objects.equals(getJwks_uri(), o.getJwks_uri())) o.setJwks_uri(null);
        if (Objects.equals(getGrant_types_supported(), o.getGrant_types_supported())) o.setGrant_types_supported(null);
        if (Objects.equals(getScopes_supported(), o.getScopes_supported())) o.setScopes_supported(null);
        if (Objects.equals(getClaims_supported(), o.getClaims_supported())) o.setClaims_supported(null);
        if (Objects.equals(getResponse_modes_supported(), o.getResponse_modes_supported())) o.setResponse_modes_supported(null);
        if (Objects.equals(getSubject_types_supported(), o.getSubject_types_supported())) o.setSubject_types_supported(null);
        if (Objects.equals(getCode_challenge_methods_supported(), o.getCode_challenge_methods_supported())) o.setCode_challenge_methods_supported(null);
        if (Objects.equals(getId_token_signing_alg_values_supported(), o.getId_token_signing_alg_values_supported())) o.setId_token_signing_alg_values_supported(null);
        if (Objects.equals(getX_sso_frame(), o.getX_sso_frame())) o.setX_sso_frame(null);
    }
}