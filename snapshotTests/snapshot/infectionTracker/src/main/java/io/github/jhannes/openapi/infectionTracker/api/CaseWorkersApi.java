package io.github.jhannes.openapi.infectionTracker.api;

import io.github.jhannes.openapi.infectionTracker.model.*;

import lombok.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.time.*;
import java.util.*;
import java.util.function.*;

import static java.net.URLEncoder.encode;
import static java.nio.charset.StandardCharsets.UTF_8;

public interface CaseWorkersApi {
    /**
     * @return CaseWorkerDto
     */
    CaseWorkerDto listCaseWorkers(
    ) throws IOException;
    /**
     * @param CaseWorkerDto  (required)
     */
    void registerCaseWorker(
            CaseWorkerDto CaseWorkerDto
    ) throws IOException;
}
