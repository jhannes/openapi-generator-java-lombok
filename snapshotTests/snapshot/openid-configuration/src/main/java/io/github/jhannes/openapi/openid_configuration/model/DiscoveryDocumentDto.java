package io.github.jhannes.openapi.openid_configuration.model;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import lombok.*;

@Data
public final class DiscoveryDocumentDto {

    @Getter @ToString @RequiredArgsConstructor
    public enum ResponseModesSupportedEnum {
        QUERY("query"),
        FRAGMENT("fragment"),
        FORM_POST("form_post");
    
        private final String name;
    }

    @Getter @ToString @RequiredArgsConstructor
    public enum SubjectTypesSupportedEnum {
        PAIRWISE("pairwise"),
        PUBLIC("public");
    
        private final String name;
    }

    @Getter @ToString @RequiredArgsConstructor
    public enum CodeChallengeMethodsSupportedEnum {
        S256("S256"),
        PLAIN("plain");
    
        private final String name;
    }

    @Getter @ToString @RequiredArgsConstructor
    public enum IdTokenSigningAlgValuesSupportedEnum {
        RS256("RS256");
    
        private final String name;
    }

    private String issuer = null;
    private URI authorization_endpoint = null;
    private URI token_endpoint = null;
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