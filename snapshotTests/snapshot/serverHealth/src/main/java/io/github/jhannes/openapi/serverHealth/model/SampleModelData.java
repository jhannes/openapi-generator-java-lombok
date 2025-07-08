package io.github.jhannes.openapi.serverHealth.model;


import java.util.function.Supplier;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Model tests for Health API
 */
public class SampleModelData extends SampleData {

    public SampleModelData(Random random) {
    	super(random);
    }

    public SampleModelData(long seed) {
        super(seed);
    }

    public DataSourceHealthDetailsDto sampleDataSourceHealthDetailsDto(String propertyName) {
        return sampleDataSourceHealthDetailsDto();
    }

    public DataSourceHealthDetailsDto sampleDataSourceHealthDetailsDto() {
        return new DataSourceHealthDetailsDto()
            .setType("DataSourceHealthDetails")
            .setUrl(sampleString("url"))
            .setLastAliveTime(sampleOffsetDateTime("lastAliveTime"))
            .setLastFailureException(sampleExceptionDto("lastFailureException"));
    }

    public ExceptionDto sampleExceptionDto(String propertyName) {
        return sampleExceptionDto();
    }

    public ExceptionDto sampleExceptionDto() {
        return new ExceptionDto()
            .setType(sampleString("type", "className"))
            .setMessage(sampleString("message"))
            .setStackTrace(sampleList(() -> sampleStackTraceInnerDto("stackTrace"), "stackTrace"));
    }

    public HealthComponentDto sampleHealthComponentDto(String propertyName) {
        return sampleHealthComponentDto();
    }

    public HealthComponentDto sampleHealthComponentDto() {
        return new HealthComponentDto()
            .setStatus(sampleHealthStatusDto("status"))
            .setDetails(sampleHealthDetailsDto("details"))
            .setTime(sampleOffsetDateTime("time"));
    }

    public HealthComponentFailureDetailsDto sampleHealthComponentFailureDetailsDto(String propertyName) {
        return sampleHealthComponentFailureDetailsDto();
    }

    public HealthComponentFailureDetailsDto sampleHealthComponentFailureDetailsDto() {
        return new HealthComponentFailureDetailsDto()
            .setType("HealthComponentFailureDetails")
            .setException(sampleExceptionDto("exception"));
    }

    public HealthDetailsDto sampleHealthDetailsDto(String propertyName) {
        return sampleHealthDetailsDto();
    }

    public HealthDetailsDto sampleHealthDetailsDto() {
        List<Supplier<HealthDetailsDto>> factories = List.of(
            () -> sampleDataSourceHealthDetailsDto().setType("DataSourceHealthDetails"),
            () -> sampleHealthComponentFailureDetailsDto().setType("HealthComponentFailureDetails"),
            () -> sampleThreadHealthDetailsDto().setType("ThreadHealthDetails")
        );
        return pickOne(factories).get();
    }

    public HealthOverviewDto sampleHealthOverviewDto(String propertyName) {
        return sampleHealthOverviewDto();
    }

    public HealthOverviewDto sampleHealthOverviewDto() {
        return new HealthOverviewDto()
            .setComponents(sampleMap(() -> sampleHealthStatusDto("components"), "components"));
    }

    public HealthStatusDto sampleHealthStatusDto(String propertyName) {
        return sampleHealthStatusDto();
    }

    public HealthStatusDto sampleHealthStatusDto() {
        return pickOne(HealthStatusDto.values());
    }

    public HealthSummaryDto sampleHealthSummaryDto(String propertyName) {
        return sampleHealthSummaryDto();
    }

    public HealthSummaryDto sampleHealthSummaryDto() {
        return new HealthSummaryDto()
            .setStatus(sampleHealthStatusDto("status"))
            .setComponents(sampleMap(() -> sampleHealthComponentDto("components"), "components"));
    }

    public StackTraceInnerDto sampleStackTraceInnerDto(String propertyName) {
        return sampleStackTraceInnerDto();
    }

    public StackTraceInnerDto sampleStackTraceInnerDto() {
        return new StackTraceInnerDto()
            .setClassName(sampleString("className", "className"))
            .setMethodName(sampleString("methodName"))
            .setFileName(sampleString("fileName"))
            .setLineNumber(sampleInteger("lineNumber"));
    }

    public ThreadHealthDetailsDto sampleThreadHealthDetailsDto(String propertyName) {
        return sampleThreadHealthDetailsDto();
    }

    public ThreadHealthDetailsDto sampleThreadHealthDetailsDto() {
        return new ThreadHealthDetailsDto()
            .setType("ThreadHealthDetails")
            .setThreadState(pickOne(ThreadHealthDetailsDto.ThreadStateEnum.values()))
            .setStackTrace(sampleList(() -> sampleStackTraceInnerDto("stackTrace"), "stackTrace"))
            .setLastAliveTime(sampleOffsetDateTime("lastAliveTime"))
            .setLastSuccessTime(sampleOffsetDateTime("lastSuccessTime"))
            .setLastFailureTime(sampleOffsetDateTime("lastFailureTime"))
            .setLastFailureException(sampleExceptionDto("lastFailureException"));
    }

}
