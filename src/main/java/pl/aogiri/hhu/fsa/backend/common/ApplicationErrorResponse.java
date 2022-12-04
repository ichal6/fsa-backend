package pl.aogiri.hhu.fsa.backend.common;

import lombok.Data;
import org.springframework.web.context.request.WebRequest;
import pl.aogiri.hhu.fsa.backend.common.exception.ApplicationException;

import java.time.Instant;

@Data
public class ApplicationErrorResponse {

    private final Instant occuredAt;
    private final String messageCode;
    private final String contextPath;

    public ApplicationErrorResponse(ApplicationException applicationException, WebRequest webRequest) {
        this.messageCode = applicationException.getError().name();
        this.occuredAt = Instant.now();
        this.contextPath = webRequest.getContextPath();
    }
}
