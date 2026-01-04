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

    /**
     * 계좌 생성
     * @param command 계좌 생성 command
     */
    public void createAccount(AccountCreateCommand command) {
        validationService.validAccountInfo(command);
        Account.of(command, repository);
    }
}