package project.transferapi.presentation.account;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.transferapi.application.account.AccountModifyCommand;
import project.transferapi.application.account.AccountsNotFoundException;
import project.transferapi.domain.account.AccountRepository;
import project.transferapi.domain.account.AccountValidationService;

@Component
@Transactional
@RequiredArgsConstructor
public class AccountModifyHandler {
    private final AccountValidationService service;

    private final AccountRepository repository;

    public void modifyAccount(AccountModifyCommand command) {
        service.validAccountInfo(command);

        repository.findAccountById(command.id())
                  .orElseThrow(() -> new AccountsNotFoundException(command.id()))
                  .modify(command.perTransferLimit(), command.dailyTransferLimit(), command.status());
    }
}
