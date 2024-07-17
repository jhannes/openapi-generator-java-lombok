package io.github.jhannes.openapi.conversations.api;

import io.github.jhannes.openapi.conversations.model.CommandToServerDto;
import io.github.jhannes.openapi.conversations.model.ConversationSnapshotDto;

import lombok.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;

public interface DefaultApi {
    /**
     * @param CommandToServerDto A command sent to the server (required)
     */
    void apiCommandsPost(
            CommandToServerDto CommandToServerDto
    ) throws IOException;
    /**
     * @return List&lt;ConversationSnapshotDto&gt;
     */
    List<ConversationSnapshotDto> apiConversationsGet(
    ) throws IOException;
}
