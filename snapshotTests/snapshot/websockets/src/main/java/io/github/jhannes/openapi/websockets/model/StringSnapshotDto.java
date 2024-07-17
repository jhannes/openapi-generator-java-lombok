package io.github.jhannes.openapi.websockets.model;

import java.time.OffsetDateTime;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
public final class StringSnapshotDto extends ChangeTrackedDto {

    private String name = null;
    private String type = null;

}