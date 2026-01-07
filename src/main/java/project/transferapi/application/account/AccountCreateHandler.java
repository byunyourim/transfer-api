package project.transferapi.application.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.transferapi.domain.account.Account;
import project.transferapi.domain.account.AccountRepository;
import project.transferapi.domain.account.AccountValidationService;

@Component
@RequiredArgsConstructor
public class AccountCreateHandler {
    private final AccountValidationService validationService;

    private final AccountRepository repository;

    public void createAccount(AccountCreateCommand command) {
        // 계좌 정보 검증
        validationService.validAccountInfo(command);

        Account account = Account.of(command, repository);
    }
}
