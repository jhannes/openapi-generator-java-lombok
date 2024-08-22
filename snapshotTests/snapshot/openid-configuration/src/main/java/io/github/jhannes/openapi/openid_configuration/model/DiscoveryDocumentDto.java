package io.github.jhannes.openapi.openid_configuration.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import lombok.*;

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

}