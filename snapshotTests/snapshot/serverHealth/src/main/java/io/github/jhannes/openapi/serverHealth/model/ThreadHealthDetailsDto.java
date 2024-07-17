package io.github.jhannes.openapi.serverHealth.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.*;

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

}