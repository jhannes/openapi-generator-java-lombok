package io.github.jhannes.openapi.infectionTracker.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public final class InfectionDto {

    private UUID id;
    private InfectionInformationDto information = new InfectionInformationDto();
    private List<ExposureDto> registeredExposures = new ArrayList<>();

    public boolean hasNoOptionalProperties() {
        return true;
    }

    public InfectionDto putAll(InfectionDto o) {
        o.copyToInfection(this);
        return this;
    }

    public InfectionDto removeWhereEqual(InfectionDto o) {
        o.removeWhereEqualFromInfection(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getId() == null) fields.add(prefix + "id");
        if (getInformation() != null) {
            fields.addAll(getInformation().missingRequiredFields(prefix + "information."));
        } else {
            fields.add(prefix + "information");
        }
        if (getRegisteredExposures() != null) {
            for (int i = 0; i < getRegisteredExposures().size(); i++) {
                fields.addAll(getRegisteredExposures().get(i).missingRequiredFields(prefix + "registeredExposures[" + i + "]."));
            }
        } else {
            fields.add(prefix + "registeredExposures");
        }
        return fields;
    }

    public void copyToInfection(InfectionDto o) {
        if (getId() != null) o.setId(getId());
        if (getInformation() != null) o.setInformation(getInformation());
        if (getRegisteredExposures() != null) o.setRegisteredExposures(getRegisteredExposures());
    }

    public void removeWhereEqualFromInfection(InfectionDto o) {
    }
}