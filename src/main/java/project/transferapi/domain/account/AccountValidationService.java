package project.transferapi.domain.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.transferapi.application.ErrorStatus;
import project.transferapi.application.account.AccountCreateCommand;
import project.transferapi.application.owner.OwnerBadRequestException;

@Service
@RequiredArgsConstructor
public class AccountValidationService {
    private final AccountRepository repository;

    /**
     * 계좌 생성 정보 검증
     * @param command 계좌 생성 정보
     */
    public void validAccountInfo(AccountCreateCommand command) {
        if (command.ownerId() == null) {
            throw new OwnerBadRequestException(ErrorStatus.OWNER_NOT_FOUND);
        }
    }
}
