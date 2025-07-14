package io.github.jhannes.openapi.infectionTracker.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
public final class InfectionInformationDto {

    private String patientName = null;
    private String patientPhoneNumber = null;
    private LocalDate likelyInfectionDate = null;
    /**
     * Free form text to describe anything about the patient
    */
    private String notes = null;

    public boolean hasNoOptionalProperties() {
        return getPatientName() == null
                && getPatientPhoneNumber() == null
                && getLikelyInfectionDate() == null
                && getNotes() == null
        ;
    }

    public InfectionInformationDto putAll(InfectionInformationDto o) {
        o.copyToInfectionInformation(this);
        return this;
    }

    public InfectionInformationDto removeWhereEqual(InfectionInformationDto o) {
        if (Objects.equals(getPatientName(), o.getPatientName())) setPatientName(null);
        if (Objects.equals(getPatientPhoneNumber(), o.getPatientPhoneNumber())) setPatientPhoneNumber(null);
        if (Objects.equals(getLikelyInfectionDate(), o.getLikelyInfectionDate())) setLikelyInfectionDate(null);
        if (Objects.equals(getNotes(), o.getNotes())) setNotes(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        return new ArrayList<>();
    }

    public void copyToInfectionInformation(InfectionInformationDto o) {
        if (getPatientName() != null) o.setPatientName(getPatientName());
        if (getPatientPhoneNumber() != null) o.setPatientPhoneNumber(getPatientPhoneNumber());
        if (getLikelyInfectionDate() != null) o.setLikelyInfectionDate(getLikelyInfectionDate());
        if (getNotes() != null) o.setNotes(getNotes());
    }
}