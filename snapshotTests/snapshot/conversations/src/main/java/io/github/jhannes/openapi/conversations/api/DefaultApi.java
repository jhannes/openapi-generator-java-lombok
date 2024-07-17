package io.github.jhannes.openapi.conversations.api;

import io.github.jhannes.openapi.conversations.model.*;

import lombok.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.time.*;
import java.util.*;
import java.util.function.*;

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
