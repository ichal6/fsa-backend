package pl.aogiri.hhu.fsa.backend.auth.user.exception;

import pl.aogiri.hhu.fsa.backend.common.error.ErrorContent;
import pl.aogiri.hhu.fsa.backend.common.exception.ApplicationException;

public class EmailAlreadyUsed extends ApplicationException {
    public EmailAlreadyUsed() {
        super(ErrorContent.EMAIL_ALREADY_USED);
    }
}
