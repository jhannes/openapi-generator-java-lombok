package io.github.jhannes.openapi.conversations.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Data
public final class SnapshotSetDto implements MessageFromServerDto {

    private List<ConversationSnapshotDto> conversations = new ArrayList<>();

}