package project.transferapi.application.owner;

import project.transferapi.application.ErrorStatus;
import project.transferapi.application.ResourceBadRequestException;

public class OwnerBadRequestException extends ResourceBadRequestException {
    public OwnerBadRequestException(ErrorStatus error) {
        super(error);
    }
}
