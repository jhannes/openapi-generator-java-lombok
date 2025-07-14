package io.github.jhannes.openapi.serverHealth.model;

import java.util.List;

public sealed interface HealthDetailsDto permits DataSourceHealthDetailsDto, HealthComponentFailureDetailsDto, ThreadHealthDetailsDto {

    String getType();

    static Class<? extends HealthDetailsDto> getType(String type) {
        return switch (type) {
            case "DataSourceHealthDetails" -> DataSourceHealthDetailsDto.class;
            case "HealthComponentFailureDetails" -> HealthComponentFailureDetailsDto.class;
            case "ThreadHealthDetails" -> ThreadHealthDetailsDto.class;
            default -> throw new IllegalArgumentException("Illegal type " + type);
        };
    }

    static DataSourceHealthDetailsDto createDataSourceHealthDetails() {
        return new DataSourceHealthDetailsDto().setType("DataSourceHealthDetails");
    }

    static HealthComponentFailureDetailsDto createHealthComponentFailureDetails() {
        return new HealthComponentFailureDetailsDto().setType("HealthComponentFailureDetails");
    }

    static ThreadHealthDetailsDto createThreadHealthDetails() {
        return new ThreadHealthDetailsDto().setType("ThreadHealthDetails");
    }

    HealthDetailsDto putAll(HealthDetailsDto o);
    HealthDetailsDto removeWhereEqual(HealthDetailsDto o);
    boolean hasNoOptionalProperties();
    List<String> missingRequiredFields(String prefix);

    default void copyToDataSourceHealthDetails(DataSourceHealthDetailsDto o) {
    }
    default void copyToHealthComponentFailureDetails(HealthComponentFailureDetailsDto o) {
    }
    default void copyToThreadHealthDetails(ThreadHealthDetailsDto o) {
    }
    default void removeWhereEqualFromDataSourceHealthDetails(DataSourceHealthDetailsDto o) {
    }
    default void removeWhereEqualFromHealthComponentFailureDetails(HealthComponentFailureDetailsDto o) {
    }
    default void removeWhereEqualFromThreadHealthDetails(ThreadHealthDetailsDto o) {
    }
}