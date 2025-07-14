package io.github.jhannes.openapi.openid_configuration.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

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

    public boolean hasNoOptionalProperties() {
        return getTyp() == null
                && getKid() == null
                && getAlg() == null
        ;
    }

    public JwtHeaderDto putAll(JwtHeaderDto o) {
        o.copyToJwtHeader(this);
        return this;
    }

    public JwtHeaderDto removeWhereEqual(JwtHeaderDto o) {
        if (Objects.equals(getTyp(), o.getTyp())) setTyp(null);
        if (Objects.equals(getKid(), o.getKid())) setKid(null);
        if (Objects.equals(getAlg(), o.getAlg())) setAlg(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToJwtHeader(JwtHeaderDto o) {
        if (getTyp() != null) o.setTyp(getTyp());
        if (getKid() != null) o.setKid(getKid());
        if (getAlg() != null) o.setAlg(getAlg());
    }
}