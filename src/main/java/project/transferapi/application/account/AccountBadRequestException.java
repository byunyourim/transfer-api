package project.transferapi.application.account;

import org.springframework.http.HttpStatus;
import project.transferapi.application.ApplicationException;
import project.transferapi.application.ErrorStatus;
import static org.springframework.http.HttpStatus.BAD_REQUEST;


public class AccountBadRequestException extends ApplicationException {
    private final Object arg;

    public AccountBadRequestException(ErrorStatus error) {
        super(error);
        this.arg = null;
    }

    public AccountBadRequestException(ErrorStatus error, Object arg) {
        super(error);
        this.arg = arg;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return BAD_REQUEST;
    }

    @Override
    public String getErrorMessage() {
        return getError().getMessage().formatted(arg);
    }
}
