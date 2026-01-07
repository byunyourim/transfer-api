package project.transferapi.application.account;

import project.transferapi.application.ErrorStatus;
import project.transferapi.application.ResourceBadRequestException;

public class AccountBadRequestException extends ResourceBadRequestException {
    public AccountBadRequestException(ErrorStatus error) {
        super(error);
    }
}
