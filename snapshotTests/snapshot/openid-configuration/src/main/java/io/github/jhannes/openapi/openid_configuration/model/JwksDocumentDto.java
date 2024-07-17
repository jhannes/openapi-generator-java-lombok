package io.github.jhannes.openapi.openid_configuration.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
public final class JwksDocumentDto {

    private List<JwksKeyDto> keys = new ArrayList<>();

}