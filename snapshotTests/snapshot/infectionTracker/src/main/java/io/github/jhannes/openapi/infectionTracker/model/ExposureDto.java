package io.github.jhannes.openapi.infectionTracker.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.*;

@Data
public final class ExposureDto {

    @Getter
    @RequiredArgsConstructor
    public enum StatusEnum {
        UNIDENTIFIED("unidentified"),
        IDENTIFIED("identified"),
        CONTACTED("contacted"),
        TESTED("tested"),
        INFECTED("infected");
    
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

}