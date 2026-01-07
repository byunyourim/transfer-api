package project.transferapi.application.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.transferapi.domain.account.AccountRepository;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountVeiwHandler {
    private final AccountRepository repo;

    public AccountView findAccounts(AccountQuery query) {
        return repo.findAccountView(query);

    }

    public AccountViewDetail findAccount(AccountQuery query) {
        return repo.findAccountDetailById(query.id());
    }
}
