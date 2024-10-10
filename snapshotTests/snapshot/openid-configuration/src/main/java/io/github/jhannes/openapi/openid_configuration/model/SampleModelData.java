package io.github.jhannes.openapi.openid_configuration.model;


import java.util.function.Supplier;
import java.util.List;
import java.util.Random;

/**
 * Model tests for Open ID Connect
 */
public class SampleModelData extends SampleData {

    public SampleModelData(Random random) {
    	super(random);
    }

    public SampleModelData(long seed) {
        super(seed);
    }

    public DiscoveryDocumentDto sampleDiscoveryDocumentDto(String propertyName) {
        return sampleDiscoveryDocumentDto();
    }

    public DiscoveryDocumentDto sampleDiscoveryDocumentDto() {
        return new DiscoveryDocumentDto()
            .setIssuer(sampleString("issuer"))
            .setAuthorization_endpoint(sampleURI("authorizationEndpoint"))
            .setToken_endpoint(sampleURI("tokenEndpoint"))
            .setUserinfo_endpoint(sampleURI("userinfoEndpoint"))
            .setEnd_session_endpoint(sampleURI("endSessionEndpoint"))
            .setJwks_uri(sampleURI("jwksUri"))
            .setResponse_modes_supported(pickSubset(DiscoveryDocumentDto.ResponseModesSupportedEnum.values()))
            .setSubject_types_supported(pickSubset(DiscoveryDocumentDto.SubjectTypesSupportedEnum.values()))
            .setCode_challenge_methods_supported(pickSubset(DiscoveryDocumentDto.CodeChallengeMethodsSupportedEnum.values()))
            .setId_token_signing_alg_values_supported(pickSome(DiscoveryDocumentDto.IdTokenSigningAlgValuesSupportedEnum.values()))
            .setX_sso_frame(sampleString("xSsoFrame", "url"));
    }

    public GrantTypeDto sampleGrantTypeDto(String propertyName) {
        return sampleGrantTypeDto();
    }

    public GrantTypeDto sampleGrantTypeDto() {
        return pickOne(GrantTypeDto.values());
    }

    public JwksDocumentDto sampleJwksDocumentDto(String propertyName) {
        return sampleJwksDocumentDto();
    }

    public JwksDocumentDto sampleJwksDocumentDto() {
        return new JwksDocumentDto();
    }

    public JwksKeyDto sampleJwksKeyDto(String propertyName) {
        return sampleJwksKeyDto();
    }

    public JwksKeyDto sampleJwksKeyDto() {
        return new JwksKeyDto()
            .setKty(sampleString("kty"))
            .setUse(sampleString("use"))
            .setKid(sampleString("kid"))
            .setX5c(sampleString("x5c"))
            .setE(sampleString("e"))
            .setN(sampleString("n"));
    }

    public JwtHeaderDto sampleJwtHeaderDto(String propertyName) {
        return sampleJwtHeaderDto();
    }

    public JwtHeaderDto sampleJwtHeaderDto() {
        return new JwtHeaderDto()
            .setTyp(sampleString("typ"))
            .setKid(sampleString("kid"))
            .setAlg(sampleString("alg"));
    }

    public JwtPayloadDto sampleJwtPayloadDto(String propertyName) {
        return sampleJwtPayloadDto();
    }

    public JwtPayloadDto sampleJwtPayloadDto() {
        return new JwtPayloadDto()
            .setIss(sampleString("iss", "url"))
            .setSub(sampleString("sub"))
            .setAud(sampleString("aud"))
            .setName(sampleString("name"))
            .setEmail(sampleString("email"))
            .setOrgId(sampleString("orgId"))
            .setOrg(sampleString("org"))
            .setPid(sampleString("pid"));
    }

    public OauthErrorDto sampleOauthErrorDto(String propertyName) {
        return sampleOauthErrorDto();
    }

    public OauthErrorDto sampleOauthErrorDto() {
        return new OauthErrorDto()
            .setError(pickOne(OauthErrorDto.ErrorEnum.values()))
            .setError_description(sampleString("errorDescription"));
    }

    public ResponseTypeDto sampleResponseTypeDto(String propertyName) {
        return sampleResponseTypeDto();
    }

    public ResponseTypeDto sampleResponseTypeDto() {
        return pickOne(ResponseTypeDto.values());
    }

    public TokenResponseDto sampleTokenResponseDto(String propertyName) {
        return sampleTokenResponseDto();
    }

    public TokenResponseDto sampleTokenResponseDto() {
        return new TokenResponseDto()
            .setAccess_token(sampleString("accessToken"))
            .setToken_type(sampleString("tokenType"))
            .setExpires_in(sampleInteger("expiresIn"))
            .setScope(sampleString("scope"))
            .setId_token(sampleString("idToken"))
            .setRefresh_token(sampleString("refreshToken"));
    }

    public UserinfoDto sampleUserinfoDto(String propertyName) {
        return sampleUserinfoDto();
    }

    public UserinfoDto sampleUserinfoDto() {
        return new UserinfoDto()
            .setSub(sampleString("sub"))
            .setName(sampleString("name"))
            .setEmail(null);
    }

}
