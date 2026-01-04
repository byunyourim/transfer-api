package project.transferapi.application.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.transferapi.domain.account.AccountValidationService;

@Component
@RequiredArgsConstructor
public class AccountCreateHandler {
    private final AccountValidationService validationService;

    public void createAccount(AccountCreateCommand command) {
        // 소유자 ID 검증
        if (command.ownerId() == null) {
            throw new ;
        }

        // 1회 이체한도
        if (command.perTransferLimit() <= 0 ) {

        }

        // 하루 이체한도
        if (command.dailyTransferLimit() <= 0) {

        }
    }
}
