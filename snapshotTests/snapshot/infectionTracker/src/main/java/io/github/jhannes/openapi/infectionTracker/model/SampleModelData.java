package io.github.jhannes.openapi.infectionTracker.model;


import java.util.function.Supplier;
import java.util.List;
import java.util.Random;

/**
 * Model tests for Infection Tracker
 */
public class SampleModelData extends SampleData {

    public SampleModelData(Random random) {
    	super(random);
    }

    public SampleModelData(long seed) {
        super(seed);
    }

    public CaseWorkerDto sampleCaseWorkerDto(String propertyName) {
        return sampleCaseWorkerDto();
    }

    public CaseWorkerDto sampleCaseWorkerDto() {
        return new CaseWorkerDto()
            .setId(sampleUUID("id"))
            .setFullName(sampleString("fullName"))
            .setEmail(sampleString("email", "email"))
            .setRole(sampleUserRoleDto("role"));
    }

    public ExposureDto sampleExposureDto(String propertyName) {
        return sampleExposureDto();
    }

    public ExposureDto sampleExposureDto() {
        return new ExposureDto()
            .setId(sampleUUID("id"))
            .setExposedPersonName(sampleString("exposedPersonName"))
            .setExposedPersonPhoneNumber(sampleString("exposedPersonPhoneNumber", "phone"))
            .setExposedDate(sampleLocalDate("exposedDate"))
            .setExposureLocation(sampleString("exposureLocation"))
            .setNotes(sampleString("notes"))
            .setCaseWorker(sampleUUID("caseWorker"))
            .setStatus(pickOne(ExposureDto.StatusEnum.values()))
            .setDelayAfterInfection(pickOne(ExposureDto.DelayAfterInfectionEnum.values()));
    }

    public InfectionDto sampleInfectionDto(String propertyName) {
        return sampleInfectionDto();
    }

    public InfectionDto sampleInfectionDto() {
        return new InfectionDto()
            .setId(sampleUUID("id"))
            .setInformation(sampleInfectionInformationDto("information"));
    }

    public InfectionInformationDto sampleInfectionInformationDto(String propertyName) {
        return sampleInfectionInformationDto();
    }

    public InfectionInformationDto sampleInfectionInformationDto() {
        return new InfectionInformationDto()
            .setPatientName(sampleString("patientName"))
            .setPatientPhoneNumber(sampleString("patientPhoneNumber", "phone"))
            .setLikelyInfectionDate(sampleLocalDate("likelyInfectionDate"))
            .setNotes(sampleString("notes"));
    }

    public UserRoleDto sampleUserRoleDto(String propertyName) {
        return sampleUserRoleDto();
    }

    public UserRoleDto sampleUserRoleDto() {
        return pickOne(UserRoleDto.values());
    }

}
