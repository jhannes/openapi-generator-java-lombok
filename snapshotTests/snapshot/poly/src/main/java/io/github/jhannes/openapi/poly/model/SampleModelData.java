package io.github.jhannes.openapi.poly.model;


import java.util.function.Supplier;
import java.util.List;
import java.util.Random;

/**
 * Model tests for Poly API
 */
public class SampleModelData extends SampleData {

    public SampleModelData(Random random) {
    	super(random);
    }

    public SampleModelData(long seed) {
        super(seed);
    }

    public AnyPartyDto sampleAnyPartyDto(String propertyName) {
        return sampleAnyPartyDto();
    }

    public AnyPartyDto sampleAnyPartyDto() {
        List<Supplier<AnyPartyDto>> factories = List.of(
            () -> sampleOrganizationDto().setType("organization"),
            () -> samplePersonDto().setType("person")
        );
        return pickOne(factories).get();
    }

    public CreationErrorDto sampleCreationErrorDto(String propertyName) {
        return sampleCreationErrorDto();
    }

    public CreationErrorDto sampleCreationErrorDto() {
        List<Supplier<CreationErrorDto>> factories = List.of(
            () -> sampleDuplicateIdentifierErrorDto().setCode("duplicate_identifier"),
            () -> sampleGeneralErrorDto().setCode("general_error"),
            () -> sampleIllegalEmailAddressErrorDto().setCode("illegal_address"),
            () -> sampleGeneralErrorDto().setCode("network_error")
        );
        return pickOne(factories).get();
    }

    public DuplicateIdentifierErrorDto sampleDuplicateIdentifierErrorDto(String propertyName) {
        return sampleDuplicateIdentifierErrorDto();
    }

    public DuplicateIdentifierErrorDto sampleDuplicateIdentifierErrorDto() {
        return new DuplicateIdentifierErrorDto()
            .setCode(sampleString("code"))
            .setIdentifierValue(sampleString("identifierValue"))
            .setEntityType(sampleString("entityType"));
    }

    public GeneralErrorDto sampleGeneralErrorDto(String propertyName) {
        return sampleGeneralErrorDto();
    }

    public GeneralErrorDto sampleGeneralErrorDto() {
        return new GeneralErrorDto()
            .setCode(sampleString("code"))
            .setDescription(sampleString("description"));
    }

    public IllegalEmailAddressErrorDto sampleIllegalEmailAddressErrorDto(String propertyName) {
        return sampleIllegalEmailAddressErrorDto();
    }

    public IllegalEmailAddressErrorDto sampleIllegalEmailAddressErrorDto() {
        return new IllegalEmailAddressErrorDto()
            .setCode(sampleString("code"))
            .setInputEmailAddress(sampleString("inputEmailAddress"));
    }

    public LogMessageDto sampleLogMessageDto(String propertyName) {
        return sampleLogMessageDto();
    }

    public LogMessageDto sampleLogMessageDto() {
        return new LogMessageDto()
            .setMessage(sampleString("message"))
            .setError(sampleObject("error"));
    }

    public NotFoundErrorDto sampleNotFoundErrorDto(String propertyName) {
        return sampleNotFoundErrorDto();
    }

    public NotFoundErrorDto sampleNotFoundErrorDto() {
        return new NotFoundErrorDto()
            .setCode(sampleString("code"))
            .setIdentifierValue(sampleString("identifierValue"))
            .setEntityType(sampleString("entityType"));
    }

    public OrganizationDto sampleOrganizationDto(String propertyName) {
        return sampleOrganizationDto();
    }

    public OrganizationDto sampleOrganizationDto() {
        return new OrganizationDto()
            .setId(sampleUUID("id"))
            .setType(sampleString("type"))
            .setName(sampleString("name"))
            .setOrganizationId(sampleString("organizationId"))
            .setUrl(sampleURI("url"))
            .setEmail(sampleString("email", "email"))
            .setPhone(sampleString("phone", "phone"));
    }

    public PersonDto samplePersonDto(String propertyName) {
        return samplePersonDto();
    }

    public PersonDto samplePersonDto() {
        return new PersonDto()
            .setId(sampleUUID("id"))
            .setType(sampleString("type"))
            .setGivenName(sampleString("givenName"))
            .setFamilyName(sampleString("familyName"))
            .setEmail(sampleString("email", "email"))
            .setPhone(sampleString("phone", "phone"))
            .setBirthDate(sampleLocalDate("birthDate"));
    }

    public UpdateErrorDto sampleUpdateErrorDto(String propertyName) {
        return sampleUpdateErrorDto();
    }

    public UpdateErrorDto sampleUpdateErrorDto() {
        List<Supplier<UpdateErrorDto>> factories = List.of(
            () -> sampleDuplicateIdentifierErrorDto().setCode("duplicate_identifier"),
            () -> sampleGeneralErrorDto().setCode("general_error"),
            () -> sampleIllegalEmailAddressErrorDto().setCode("illegal_address"),
            () -> sampleGeneralErrorDto().setCode("network_error"),
            () -> sampleNotFoundErrorDto().setCode("not_found")
        );
        return pickOne(factories).get();
    }

}
