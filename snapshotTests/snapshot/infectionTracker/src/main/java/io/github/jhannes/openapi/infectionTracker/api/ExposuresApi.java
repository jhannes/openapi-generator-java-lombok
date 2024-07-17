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

public interface ExposuresApi {
    /**
     * @param exposureDate  (query) (optional
     * @param maxCount  (query) (optional)
     * @return ExposureDto
     */
    ExposureDto listExposures(
            Optional<List<LocalDate>> exposureDate,
            Optional<Integer> maxCount
    ) throws IOException;

    @Data
    class ListExposuresQuery {
        private List<LocalDate> exposureDate;
        private Integer maxCount;

        public String toUrlEncoded() {
            List<String> parameters = new ArrayList<>();
            if (exposureDate != null) {
                parameters.add("exposureDate=" + encode(exposureDate.toString(), UTF_8));
            }
            if (maxCount != null) {
                parameters.add("maxCount=" + encode(maxCount.toString(), UTF_8));
            }
            return String.join("&", parameters);
        }
    }
    /**
     * @param exposureId  (path) (required)
     * @param ExposureDto  (optional)
     */
    void updateExposure(
            UUID exposureId,
            Optional<ExposureDto> ExposureDto
    ) throws IOException;
}
