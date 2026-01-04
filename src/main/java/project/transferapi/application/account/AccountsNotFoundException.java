package project.transferapi.application.account;

import project.transferapi.application.ResourceBadRequestException;

import static project.transferapi.application.ErrorStatus.ACCOUNT_NOT_FOUND;

public class AccountsNotFoundException extends ResourceBadRequestException {
    public AccountsNotFoundException(Object id) {
        super(ACCOUNT_NOT_FOUND, id);
    }
}
