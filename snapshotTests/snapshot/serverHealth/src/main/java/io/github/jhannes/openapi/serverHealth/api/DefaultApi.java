package io.github.jhannes.openapi.serverHealth.api;

import io.github.jhannes.openapi.serverHealth.model.*;

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
     * @return HealthSummaryDto
     */
    HealthSummaryDto listHealthResult(
    ) throws IOException;
}
