package project.transferapi.application.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.transferapi.domain.account.AccountRepository;
import project.transferapi.presentation.account.AccountCreateResponse;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountVeiwHandler {
    private final AccountRepository repository;

    public AccountView findAccounts(AccountQuery query) {
        return repository.findAccountView(query);

    }

    public AccountViewDetail findAccount(AccountQuery query) {
        return repository.findAccountDetailById(query.id());
    }
}
