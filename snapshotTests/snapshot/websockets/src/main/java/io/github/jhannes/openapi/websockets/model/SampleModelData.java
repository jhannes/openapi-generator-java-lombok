package io.github.jhannes.openapi.websockets.model;


import java.util.function.Supplier;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Model tests for WebSockets
 */
public class SampleModelData extends SampleData {

    public SampleModelData(Random random) {
    	super(random);
    }

    public SampleModelData(long seed) {
        super(seed);
    }

    public ChangeTrackedDto sampleChangeTrackedDto(String propertyName) {
        return sampleChangeTrackedDto();
    }

    public ChangeTrackedDto sampleChangeTrackedDto() {
        return new ChangeTrackedDto()
            .setCreatedAt(sampleOffsetDateTime("createdAt"))
            .setCreatedBy(sampleString("createdBy", "username"))
            .setUpdatedAt(sampleOffsetDateTime("updatedAt"))
            .setUpdatedBy(sampleString("updatedBy", "username"));
    }

    public CreatePersonCommandDto sampleCreatePersonCommandDto(String propertyName) {
        return sampleCreatePersonCommandDto();
    }

    public CreatePersonCommandDto sampleCreatePersonCommandDto() {
        return new CreatePersonCommandDto()
            .setCommand("createPerson")
            .setId(sampleUUID("id"))
            .setPerson(samplePersonDto("person"));
    }

    public PersonDto samplePersonDto(String propertyName) {
        return samplePersonDto();
    }

    public PersonDto samplePersonDto() {
        return new PersonDto()
            .setEmail(sampleString("email", "email"))
            .setId(sampleUUID("id"))
            .setType(sampleString("type"))
            .setName(samplePersonNameDto("name"))
            .setPhone(sampleString("phone", "phone"))
            .setBirthDate(sampleLocalDate("birthDate"))
            .setGender(pickOne(PersonDto.GenderEnum.values()));
    }

    public PersonNameDto samplePersonNameDto(String propertyName) {
        return samplePersonNameDto();
    }

    public PersonNameDto samplePersonNameDto() {
        return new PersonNameDto()
            .setGivenName(sampleString("givenName"))
            .setFamilyName(sampleString("familyName"));
    }

    public PersonSnapshotDto samplePersonSnapshotDto(String propertyName) {
        return samplePersonSnapshotDto();
    }

    public PersonSnapshotDto samplePersonSnapshotDto() {
        return new PersonSnapshotDto()
            .setCreatedAt(sampleOffsetDateTime("createdAt"))
            .setCreatedBy(sampleString("createdBy", "username"))
            .setUpdatedAt(sampleOffsetDateTime("updatedAt"))
            .setUpdatedBy(sampleString("updatedBy", "username"))
            .setEmail(sampleString("email", "email"))
            .setId(sampleUUID("id"))
            .setType(sampleString("type"))
            .setName(samplePersonNameDto("name"))
            .setPhone(sampleString("phone", "phone"))
            .setBirthDate(sampleLocalDate("birthDate"))
            .setGender(pickOne(PersonSnapshotDto.GenderEnum.values()))
            .setExtra(sampleString("extra"));
    }

    public RecipientDto sampleRecipientDto(String propertyName) {
        return sampleRecipientDto();
    }

    public RecipientDto sampleRecipientDto() {
        return new RecipientDto()
            .setEmail(sampleString("email", "email"));
    }

    public StringSnapshotDto sampleStringSnapshotDto(String propertyName) {
        return sampleStringSnapshotDto();
    }

    public StringSnapshotDto sampleStringSnapshotDto() {
        return new StringSnapshotDto()
            .setCreatedAt(sampleOffsetDateTime("createdAt"))
            .setCreatedBy(sampleString("createdBy", "username"))
            .setUpdatedAt(sampleOffsetDateTime("updatedAt"))
            .setUpdatedBy(sampleString("updatedBy", "username"))
            .setName(sampleString("name"))
            .setType(sampleString("type"));
    }

    public SubscribeDto sampleSubscribeDto(String propertyName) {
        return sampleSubscribeDto();
    }

    public SubscribeDto sampleSubscribeDto() {
        return new SubscribeDto()
            .setRequest("Subscribe");
    }

    public UnsubscribeDto sampleUnsubscribeDto(String propertyName) {
        return sampleUnsubscribeDto();
    }

    public UnsubscribeDto sampleUnsubscribeDto() {
        return new UnsubscribeDto()
            .setRequest("Unsubscribe");
    }

    public UpdatePersonCommandDto sampleUpdatePersonCommandDto(String propertyName) {
        return sampleUpdatePersonCommandDto();
    }

    public UpdatePersonCommandDto sampleUpdatePersonCommandDto() {
        return new UpdatePersonCommandDto()
            .setCommand("updatePerson")
            .setId(sampleUUID("id"))
            .setPerson(samplePersonDto("person"));
    }

    public WebSocketCommandDto sampleWebSocketCommandDto(String propertyName) {
        return sampleWebSocketCommandDto();
    }

    public WebSocketCommandDto sampleWebSocketCommandDto() {
        List<Supplier<WebSocketCommandDto>> factories = List.of(
            () -> sampleCreatePersonCommandDto().setCommand("createPerson"),
            () -> sampleUpdatePersonCommandDto().setCommand("updatePerson")
        );
        return pickOne(factories).get();
    }

    public WebSocketMessageDto sampleWebSocketMessageDto(String propertyName) {
        return sampleWebSocketMessageDto();
    }

    public WebSocketMessageDto sampleWebSocketMessageDto() {
        List<Supplier<WebSocketMessageDto>> factories = List.of(
            () -> sampleUpdatePersonCommandDto().setCommand("updatePerson"),
            () -> sampleCreatePersonCommandDto().setCommand("createPerson")
        );
        return pickOne(factories).get();
    }

    public WebSocketRequestDto sampleWebSocketRequestDto(String propertyName) {
        return sampleWebSocketRequestDto();
    }

    public WebSocketRequestDto sampleWebSocketRequestDto() {
        List<Supplier<WebSocketRequestDto>> factories = List.of(
            () -> sampleSubscribeDto().setRequest("Subscribe")
        );
        return pickOne(factories).get();
    }

}
