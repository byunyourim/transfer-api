package project.transferapi.application;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class ApplicationException extends RuntimeException {

    private final ErrorStatus error;

    public ApplicationException(ErrorStatus error ) {
        super();
        this.error = error;
    }

    public ErrorStatus getError() {
        return error;
    }

    public String getMessage() {
        return getErrorMessage();
    }

    public abstract HttpStatus getHttpStatus();

    public abstract String getErrorMessage();
}
