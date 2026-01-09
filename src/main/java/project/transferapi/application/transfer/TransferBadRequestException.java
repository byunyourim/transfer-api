package project.transferapi.application.transfer;

import project.transferapi.application.ErrorStatus;
import project.transferapi.application.ResourceBadRequestException;

public class TransferBadRequestException extends ResourceBadRequestException {
    public TransferBadRequestException(ErrorStatus error) {
        super(error);
    }

    public TransferBadRequestException(ErrorStatus error, Object arg) {
        super(error, arg);

    }
}
