package io.github.jhannes.openapi.poly.api;

import io.github.jhannes.openapi.poly.model.*;

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
     * @param LogMessageDto  (optional)
     */
    void logMessage(
            Optional<LogMessageDto> LogMessageDto
    ) throws IOException;
    /**
     * @return AnyPartyDto
     */
    AnyPartyDto partiesGet(
    ) throws IOException;
    /**
     * @param id  (path) (required)
     * @param AnyPartyDto  (optional)
     */
    void partiesIdPut(
            UUID id,
            Optional<AnyPartyDto> AnyPartyDto
    ) throws IOException;
    /**
     * @param AnyPartyDto  (optional)
     */
    void partiesPost(
            Optional<AnyPartyDto> AnyPartyDto
    ) throws IOException;
}
