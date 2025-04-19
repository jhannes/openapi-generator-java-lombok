package io.github.jhannes.openapi.conversations.model;


import java.util.function.Supplier;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Model tests for Conversations
 */
public class SampleModelData extends SampleData {

    public SampleModelData(Random random) {
    	super(random);
    }

    public SampleModelData(long seed) {
        super(seed);
    }

    public AddMessageToConversationDeltaDto sampleAddMessageToConversationDeltaDto(String propertyName) {
        return sampleAddMessageToConversationDeltaDto();
    }

    public AddMessageToConversationDeltaDto sampleAddMessageToConversationDeltaDto() {
        return new AddMessageToConversationDeltaDto()
            .setDelta("AddMessageToConversationDelta")
            .setConversationId(sampleUUID("conversationId"))
            .setMessageId(sampleUUID("messageId"))
            .setMessage(sampleConversationMessageDto("message"));
    }

    public ChangeTrackedDto sampleChangeTrackedDto(String propertyName) {
        return sampleChangeTrackedDto();
    }

    public ChangeTrackedDto sampleChangeTrackedDto() {
        return new ChangeTrackedDto()
            .setCreatedAt(sampleOffsetDateTime("createdAt"))
            .setUpdatedAt(sampleOffsetDateTime("updatedAt"));
    }

    public CommandToServerDto sampleCommandToServerDto(String propertyName) {
        return sampleCommandToServerDto();
    }

    public CommandToServerDto sampleCommandToServerDto() {
        return new CommandToServerDto()
            .setId(sampleUUID("id"))
            .setClientTime(sampleOffsetDateTime("clientTime"))
            .setDelta(sampleDeltaDto("delta"));
    }

    public ConversationInfoDto sampleConversationInfoDto(String propertyName) {
        return sampleConversationInfoDto();
    }

    public ConversationInfoDto sampleConversationInfoDto() {
        return new ConversationInfoDto()
            .setTitle(sampleString("title"))
            .setSummary(sampleString("summary"));
    }

    public ConversationMessageDto sampleConversationMessageDto(String propertyName) {
        return sampleConversationMessageDto();
    }

    public ConversationMessageDto sampleConversationMessageDto() {
        return new ConversationMessageDto()
            .setText(sampleString("text"))
            .setTags(sampleSet(() -> sampleString("tags"), "tags"));
    }

    public ConversationMessageSnapshotDto sampleConversationMessageSnapshotDto(String propertyName) {
        return sampleConversationMessageSnapshotDto();
    }

    public ConversationMessageSnapshotDto sampleConversationMessageSnapshotDto() {
        return new ConversationMessageSnapshotDto()
            .setCreatedAt(sampleOffsetDateTime("createdAt"))
            .setUpdatedAt(sampleOffsetDateTime("updatedAt"))
            .setText(sampleString("text"))
            .setTags(sampleSet(() -> sampleString("tags"), "tags"));
    }

    public ConversationSnapshotDto sampleConversationSnapshotDto(String propertyName) {
        return sampleConversationSnapshotDto();
    }

    public ConversationSnapshotDto sampleConversationSnapshotDto() {
        return new ConversationSnapshotDto()
            .setCreatedAt(sampleOffsetDateTime("createdAt"))
            .setUpdatedAt(sampleOffsetDateTime("updatedAt"))
            .setId(sampleUUID("id"))
            .setInfo(sampleConversationInfoDto("info"))
            .setMessages(sampleMap(() -> sampleConversationMessageSnapshotDto("messages"), "messages"));
    }

    public CreateConversationDeltaDto sampleCreateConversationDeltaDto(String propertyName) {
        return sampleCreateConversationDeltaDto();
    }

    public CreateConversationDeltaDto sampleCreateConversationDeltaDto() {
        return new CreateConversationDeltaDto()
            .setDelta("CreateConversationDelta")
            .setConversationId(sampleUUID("conversationId"))
            .setInfo(sampleConversationInfoDto("info"));
    }

    public DeltaDto sampleDeltaDto(String propertyName) {
        return sampleDeltaDto();
    }

    public DeltaDto sampleDeltaDto() {
        List<Supplier<DeltaDto>> factories = List.of(
            () -> sampleAddMessageToConversationDeltaDto().setDelta("AddMessageToConversationDelta"),
            () -> sampleUpdateConversationDeltaDto().setDelta("UpdateConversationDelta"),
            () -> sampleCreateConversationDeltaDto().setDelta("CreateConversationDelta")
        );
        return pickOne(factories).get();
    }

    public EventFromServerDto sampleEventFromServerDto(String propertyName) {
        return sampleEventFromServerDto();
    }

    public EventFromServerDto sampleEventFromServerDto() {
        return new EventFromServerDto()
            .setId(sampleUUID("id"))
            .setClientTime(sampleOffsetDateTime("clientTime"))
            .setDelta(sampleDeltaDto("delta"))
            .setServerTime(sampleOffsetDateTime("serverTime"))
            .setUsername(sampleString("username"));
    }

    public MessageFromServerDto sampleMessageFromServerDto(String propertyName) {
        return sampleMessageFromServerDto();
    }

    public MessageFromServerDto sampleMessageFromServerDto() {
        List<Supplier<MessageFromServerDto>> factories = List.of(
        );
        return pickOne(factories).get();
    }

    public MessageToServerDto sampleMessageToServerDto(String propertyName) {
        return sampleMessageToServerDto();
    }

    public MessageToServerDto sampleMessageToServerDto() {
        List<Supplier<MessageToServerDto>> factories = List.of(
        );
        return pickOne(factories).get();
    }

    public RequestToServerDto sampleRequestToServerDto(String propertyName) {
        return sampleRequestToServerDto();
    }

    public RequestToServerDto sampleRequestToServerDto() {
        List<Supplier<RequestToServerDto>> factories = List.of(
            () -> sampleSubscribeRequestDto().setRequest("SubscribeRequest")
        );
        return pickOne(factories).get();
    }

    public SnapshotSetDto sampleSnapshotSetDto(String propertyName) {
        return sampleSnapshotSetDto();
    }

    public SnapshotSetDto sampleSnapshotSetDto() {
        return new SnapshotSetDto()
            .setConversations(sampleList(() -> sampleConversationSnapshotDto("conversations"), "conversations"));
    }

    public SubscribeRequestDto sampleSubscribeRequestDto(String propertyName) {
        return sampleSubscribeRequestDto();
    }

    public SubscribeRequestDto sampleSubscribeRequestDto() {
        return new SubscribeRequestDto()
            .setRequest("SubscribeRequest")
            .setClientId(sampleUUID("clientId"));
    }

    public UpdateConversationDeltaDto sampleUpdateConversationDeltaDto(String propertyName) {
        return sampleUpdateConversationDeltaDto();
    }

    public UpdateConversationDeltaDto sampleUpdateConversationDeltaDto() {
        return new UpdateConversationDeltaDto()
            .setDelta("UpdateConversationDelta")
            .setConversationId(sampleUUID("conversationId"))
            .setInfo(sampleConversationInfoDto("info"));
    }

}
