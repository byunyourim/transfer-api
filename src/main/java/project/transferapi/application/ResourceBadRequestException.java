package project.transferapi.application;

import org.springframework.http.HttpStatus;

public class ResourceBadRequestException extends ApplicationException {
    private final Object msg;

    public ResourceBadRequestException(ErrorStatus error) {
        super(error);
        this.msg = null;
    }

    public ResourceBadRequestException(ErrorStatus error, Object msg) {
        super(error);
        this.msg = msg;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
