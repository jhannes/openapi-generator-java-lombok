package io.github.jhannes.openapi.fakerestapi.model;

import java.net.URI;
import lombok.*;

@Data
public final class CoverPhotoDto {

    private Integer id = null;
    private Integer idBook = null;
    private URI url = null;

}