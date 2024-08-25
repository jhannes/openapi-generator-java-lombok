package io.github.jhannes.openapi.infectionTracker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.*;

@Data
public final class InfectionDto {

    private UUID id;
    private InfectionInformationDto information = new InfectionInformationDto();
    private List<ExposureDto> registeredExposures = new ArrayList<>();

    public boolean isEmpty() {
        return false;
    }

    public InfectionDto putAll(InfectionDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getInformation() != null) setInformation(o.getInformation());
        if (o.getRegisteredExposures() != null) setRegisteredExposures(o.getRegisteredExposures());
        return this;
    }

    public InfectionDto removeWhereEqual(InfectionDto o) {
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getId() == null) fields.add(prefix + "id");
        if (getInformation() == null) fields.add(prefix + "information");
        if (getRegisteredExposures() == null) fields.add(prefix + "registeredExposures");
        return fields;
    }

}