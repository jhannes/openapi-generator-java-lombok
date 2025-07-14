package io.github.jhannes.openapi.serverHealth.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Data
public final class ThreadHealthDetailsDto implements HealthDetailsDto {

    @Getter
    @RequiredArgsConstructor
    public enum ThreadStateEnum {
        NEW("NEW"),
        RUNNABLE("RUNNABLE"),
        WAITING("WAITING"),
        TIMED_WAITING("TIMED_WAITING"),
        TERMINATED("TERMINATED");
    
        private final String value;
    
        @Override
        public String toString() {
            return value;
        }
    }

    private String type = "ThreadHealthDetails";
    private ThreadStateEnum threadState = null;
    private List<StackTraceInnerDto> stackTrace = new ArrayList<>();
    private OffsetDateTime lastAliveTime = null;
    private OffsetDateTime lastSuccessTime = null;
    private OffsetDateTime lastFailureTime = null;
    private ExceptionDto lastFailureException = null;

    public boolean hasNoOptionalProperties() {
        return getThreadState() == null
                && getStackTrace() == null
                && getLastAliveTime() == null
                && getLastSuccessTime() == null
                && getLastFailureTime() == null
                && getLastFailureException() == null
        ;
    }

    public ThreadHealthDetailsDto putAll(ThreadHealthDetailsDto o) {
        o.copyToThreadHealthDetails(this);
        return this;
    }

    public ThreadHealthDetailsDto putAll(HealthDetailsDto o) {
        o.copyToThreadHealthDetails(this);
        return this;
    }

    public ThreadHealthDetailsDto removeWhereEqual(ThreadHealthDetailsDto o) {
        o.removeWhereEqualFromThreadHealthDetails(this);
        return this;
    }

    public ThreadHealthDetailsDto removeWhereEqual(HealthDetailsDto o) {
        o.removeWhereEqualFromThreadHealthDetails(this);
        return this;
    }

    public List<String> missingRequiredFields(String prefix) {
        List<String> fields = new ArrayList<>();
        if (getType() == null) fields.add(prefix + "type");
        if (getStackTrace() != null) {
            for (int i = 0; i < getStackTrace().size(); i++) {
                fields.addAll(getStackTrace().get(i).missingRequiredFields(prefix + "stackTrace[" + i + "]."));
            }
        }
        if (getLastFailureException() != null) {
            fields.addAll(getLastFailureException().missingRequiredFields(prefix + "lastFailureException."));
        }
        return fields;
    }

    public void copyToThreadHealthDetails(ThreadHealthDetailsDto o) {
        if (getThreadState() != null) o.setThreadState(getThreadState());
        if (getStackTrace() != null) o.setStackTrace(getStackTrace());
        if (getLastAliveTime() != null) o.setLastAliveTime(getLastAliveTime());
        if (getLastSuccessTime() != null) o.setLastSuccessTime(getLastSuccessTime());
        if (getLastFailureTime() != null) o.setLastFailureTime(getLastFailureTime());
        if (getLastFailureException() != null) o.setLastFailureException(getLastFailureException());
    }

    public void removeWhereEqualFromThreadHealthDetails(ThreadHealthDetailsDto o) {
        if (Objects.equals(getThreadState(), o.getThreadState())) o.setThreadState(null);
        if (Objects.equals(getStackTrace(), o.getStackTrace())) o.setStackTrace(null);
        if (Objects.equals(getLastAliveTime(), o.getLastAliveTime())) o.setLastAliveTime(null);
        if (Objects.equals(getLastSuccessTime(), o.getLastSuccessTime())) o.setLastSuccessTime(null);
        if (Objects.equals(getLastFailureTime(), o.getLastFailureTime())) o.setLastFailureTime(null);
        if (Objects.equals(getLastFailureException(), o.getLastFailureException())) o.setLastFailureException(null);
    }
}