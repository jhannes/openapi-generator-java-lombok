package io.github.jhannes.openapi.websockets.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.*;

@Data
public final class PersonSnapshotDto implements ChangeTrackedInterface, PersonInterface {

    private OffsetDateTime createdAt;
    private String createdBy;
    private OffsetDateTime updatedAt = null;
    private String updatedBy = null;
    private String email = null;
    private UUID id = null;
    private String type = null;
    private PersonNameDto name = null;
    private String phone = null;
    private LocalDate birthDate = null;
    private GenderEnum gender = null;
    private String extra = null;

}