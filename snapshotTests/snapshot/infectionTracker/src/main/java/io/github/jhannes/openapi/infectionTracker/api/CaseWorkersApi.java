package io.github.jhannes.openapi.infectionTracker.api;

import io.github.jhannes.openapi.infectionTracker.model.CaseWorkerDto;

import lombok.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

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
