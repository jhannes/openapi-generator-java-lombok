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

    public boolean hasNoOptionalProperties() {
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
        o.copyToExposure(this);
        return this;
    }

    public ExposureDto removeWhereEqual(ExposureDto o) {
        o.removeWhereEqualFromExposure(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getStatus() == null) fields.add(prefix + "status");
        return fields;
    }

    public void copyToExposure(ExposureDto o) {
        if (getId() != null) o.setId(getId());
        if (getExposedPersonName() != null) o.setExposedPersonName(getExposedPersonName());
        if (getExposedPersonPhoneNumber() != null) o.setExposedPersonPhoneNumber(getExposedPersonPhoneNumber());
        if (getExposedDate() != null) o.setExposedDate(getExposedDate());
        if (getExposureLocation() != null) o.setExposureLocation(getExposureLocation());
        if (getNotes() != null) o.setNotes(getNotes());
        if (getCaseWorker() != null) o.setCaseWorker(getCaseWorker());
        if (getStatus() != null) o.setStatus(getStatus());
        if (getDelayAfterInfection() != null) o.setDelayAfterInfection(getDelayAfterInfection());
    }

    public void removeWhereEqualFromExposure(ExposureDto o) {
        if (Objects.equals(getId(), o.getId())) o.setId(null);
        if (Objects.equals(getExposedPersonName(), o.getExposedPersonName())) o.setExposedPersonName(null);
        if (Objects.equals(getExposedPersonPhoneNumber(), o.getExposedPersonPhoneNumber())) o.setExposedPersonPhoneNumber(null);
        if (Objects.equals(getExposedDate(), o.getExposedDate())) o.setExposedDate(null);
        if (Objects.equals(getExposureLocation(), o.getExposureLocation())) o.setExposureLocation(null);
        if (Objects.equals(getNotes(), o.getNotes())) o.setNotes(null);
        if (Objects.equals(getCaseWorker(), o.getCaseWorker())) o.setCaseWorker(null);
        if (Objects.equals(getDelayAfterInfection(), o.getDelayAfterInfection())) o.setDelayAfterInfection(null);
    }
}