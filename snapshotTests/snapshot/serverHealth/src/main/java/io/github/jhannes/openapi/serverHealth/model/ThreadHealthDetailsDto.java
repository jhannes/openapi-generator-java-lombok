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
        if (o.getThreadState() != null) setThreadState(o.getThreadState());
        if (o.getStackTrace() != null) setStackTrace(o.getStackTrace());
        if (o.getLastAliveTime() != null) setLastAliveTime(o.getLastAliveTime());
        if (o.getLastSuccessTime() != null) setLastSuccessTime(o.getLastSuccessTime());
        if (o.getLastFailureTime() != null) setLastFailureTime(o.getLastFailureTime());
        if (o.getLastFailureException() != null) setLastFailureException(o.getLastFailureException());
        return this;
    }

    public ThreadHealthDetailsDto putAll(HealthDetailsDto o) {
        if (o instanceof ThreadHealthDetailsDto same) putAll(same);
        return this;
    }

    public ThreadHealthDetailsDto removeWhereEqual(ThreadHealthDetailsDto o) {
        if (Objects.equals(getThreadState(), o.getThreadState())) setThreadState(null);
        if (Objects.equals(getStackTrace(), o.getStackTrace())) setStackTrace(null);
        if (Objects.equals(getLastAliveTime(), o.getLastAliveTime())) setLastAliveTime(null);
        if (Objects.equals(getLastSuccessTime(), o.getLastSuccessTime())) setLastSuccessTime(null);
        if (Objects.equals(getLastFailureTime(), o.getLastFailureTime())) setLastFailureTime(null);
        if (Objects.equals(getLastFailureException(), o.getLastFailureException())) setLastFailureException(null);
        return this;
    }

    public ThreadHealthDetailsDto removeWhereEqual(HealthDetailsDto o) {
        if (o instanceof ThreadHealthDetailsDto same) removeWhereEqual(same);
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

}