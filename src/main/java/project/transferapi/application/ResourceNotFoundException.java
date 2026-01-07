package project.transferapi.application;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApplicationException {

    public ResourceNotFoundException(ErrorStatus error) {
        super(error);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
