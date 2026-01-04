package project.transferapi.application.user;

import project.transferapi.application.ErrorStatus;
import project.transferapi.application.ResourceBadRequestException;

public class UserBadRequestException extends ResourceBadRequestException {
    public UserBadRequestException(ErrorStatus error) {
        super(error);
    }
}
