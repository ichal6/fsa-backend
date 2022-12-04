package pl.aogiri.hhu.fsa.backend.common.exception;

import lombok.Getter;
import pl.aogiri.hhu.fsa.backend.common.error.ErrorContent;

@Getter
public abstract class ApplicationException extends Throwable {
    private final ErrorContent error;

    public ApplicationException(ErrorContent error) {
        super(error.name());
        this.error = error;
    }
}
