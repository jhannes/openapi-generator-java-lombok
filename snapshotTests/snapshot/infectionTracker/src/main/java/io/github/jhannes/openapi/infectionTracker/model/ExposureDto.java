package io.github.jhannes.openapi.infectionTracker.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
public final class ExposureDto {

    @Getter
    @RequiredArgsConstructor
    public enum StatusEnum {
        unidentified("unidentified"),
        identified("identified"),
        contacted("contacted"),
        tested("tested"),
        infected("infected");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    @Getter
    @RequiredArgsConstructor
    public enum DelayAfterInfectionEnum {
        NUMBER_MINUS_2(-2),
        NUMBER_MINUS_1(-1),
        NUMBER_0(0),
        NUMBER_1(1),
        NUMBER_2(2),
        NUMBER_3(3),
        NUMBER_4(4);
    
        private final Integer value;
    
        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private UUID id = null;
    private String exposedPersonName = null;
    private String exposedPersonPhoneNumber = null;
    private LocalDate exposedDate = null;
    /**
     * Address or other identifying description of the location
    */
    private String exposureLocation = null;
    /**
     * Information that may be relevant to identify the person fully or determine if they are infected
    */
    private String notes = null;
    /**
     * The id of the case worker assigned to follow up this person
    */
    private UUID caseWorker = null;
    private StatusEnum status;
    private DelayAfterInfectionEnum delayAfterInfection = null;

    public boolean empty() {
        return getId() == null
                && getExposedPersonName() == null
                && getExposedPersonPhoneNumber() == null
                && getExposedDate() == null
                && getExposureLocation() == null
                && getNotes() == null
                && getCaseWorker() == null
                && getDelayAfterInfection() == null
        ;
    }

    public ExposureDto putAll(ExposureDto o) {
        if (o.getId() != null) setId(o.getId());
        if (o.getExposedPersonName() != null) setExposedPersonName(o.getExposedPersonName());
        if (o.getExposedPersonPhoneNumber() != null) setExposedPersonPhoneNumber(o.getExposedPersonPhoneNumber());
        if (o.getExposedDate() != null) setExposedDate(o.getExposedDate());
        if (o.getExposureLocation() != null) setExposureLocation(o.getExposureLocation());
        if (o.getNotes() != null) setNotes(o.getNotes());
        if (o.getCaseWorker() != null) setCaseWorker(o.getCaseWorker());
        if (o.getStatus() != null) setStatus(o.getStatus());
        if (o.getDelayAfterInfection() != null) setDelayAfterInfection(o.getDelayAfterInfection());
        return this;
    }

    public ExposureDto removeWhereEqual(ExposureDto o) {
        if (Objects.equals(getId(), o.getId())) setId(null);
        if (Objects.equals(getExposedPersonName(), o.getExposedPersonName())) setExposedPersonName(null);
        if (Objects.equals(getExposedPersonPhoneNumber(), o.getExposedPersonPhoneNumber())) setExposedPersonPhoneNumber(null);
        if (Objects.equals(getExposedDate(), o.getExposedDate())) setExposedDate(null);
        if (Objects.equals(getExposureLocation(), o.getExposureLocation())) setExposureLocation(null);
        if (Objects.equals(getNotes(), o.getNotes())) setNotes(null);
        if (Objects.equals(getCaseWorker(), o.getCaseWorker())) setCaseWorker(null);
        if (Objects.equals(getDelayAfterInfection(), o.getDelayAfterInfection())) setDelayAfterInfection(null);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getStatus() == null) fields.add(prefix + "status");
        return fields;
    }

}