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

public interface CasesApi {
    /**
     * @param caseId  (path) (required)
     * @return InfectionDto
     */
    InfectionDto getCaseDetails(
            UUID caseId
    ) throws IOException;
    /**
     * @return InfectionDto
     */
    InfectionDto listCases(
    ) throws IOException;
    /**
     * @param InfectionInformationDto  (optional)
     */
    void newCase(
            Optional<InfectionInformationDto> InfectionInformationDto
    ) throws IOException;
    /**
     * @param caseId  (path) (required)
     * @param ExposureDto  (optional)
     */
    void registerExposure(
            UUID caseId,
            Optional<ExposureDto> ExposureDto
    ) throws IOException;
}
