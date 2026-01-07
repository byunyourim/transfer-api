package project.transferapi.application.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.transferapi.domain.account.Account;
import project.transferapi.domain.account.AccountRepository;
import project.transferapi.domain.user.UserValidationService;

@Component
@RequiredArgsConstructor
public class AccountCreateHandler {
    private final UserValidationService userValidationService;

    private final AccountRepository repository;

    public void createAccount(AccountCreateCommand command) {
        userValidationService.validUser(command.userId());
        Account.of(command, repository);
    }
}