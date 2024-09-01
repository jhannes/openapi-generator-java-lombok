package io.github.jhannes.openapi.infectionTracker.model;

import java.time.LocalDate;
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

    public boolean empty() {
        return getPatientName() == null
                && getPatientPhoneNumber() == null
                && getLikelyInfectionDate() == null
                && getNotes() == null
        ;
    }

    public InfectionInformationDto putAll(InfectionInformationDto o) {
        if (o.getPatientName() != null) setPatientName(o.getPatientName());
        if (o.getPatientPhoneNumber() != null) setPatientPhoneNumber(o.getPatientPhoneNumber());
        if (o.getLikelyInfectionDate() != null) setLikelyInfectionDate(o.getLikelyInfectionDate());
        if (o.getNotes() != null) setNotes(o.getNotes());
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
        return List.of();
    }

}