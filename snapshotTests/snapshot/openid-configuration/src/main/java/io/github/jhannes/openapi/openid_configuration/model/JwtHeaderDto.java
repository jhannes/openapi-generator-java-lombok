package io.github.jhannes.openapi.openid_configuration.model;

import lombok.*;

@Data
public final class JwtHeaderDto {

    /**
     * Type of JWT
    */
    private String typ = null;
    /**
     * Key ID - used to look up the public key/X.509 certificate in the JWKS
    */
    private String kid = null;
    /**
     * Algorithm used to sign the JWT. Normally RS256 (RSA signed SHA-256)
    */
    private String alg = null;

}