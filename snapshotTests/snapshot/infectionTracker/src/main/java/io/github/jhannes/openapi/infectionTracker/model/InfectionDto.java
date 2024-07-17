package io.github.jhannes.openapi.infectionTracker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.*;

@Data
public final class InfectionDto {

    private UUID id;
    private InfectionInformationDto information;
    private List<ExposureDto> registeredExposures = new ArrayList<>();

}