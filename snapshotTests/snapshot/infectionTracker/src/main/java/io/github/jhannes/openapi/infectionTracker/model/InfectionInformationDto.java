package io.github.jhannes.openapi.infectionTracker.model;

import java.time.LocalDate;
import lombok.*;

@Data
public final class InfectionInformationDto {

    private String patientName = null;
    private String patientPhoneNumber = null;
    private LocalDate likelyInfectionDate = null;
    /**
     * Free form text to describe anything about the patient
    */
    private String notes = null;

}