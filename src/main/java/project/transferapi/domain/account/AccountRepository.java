package project.transferapi.domain.account;

import project.transferapi.application.account.AccountQuery;
import project.transferapi.application.account.AccountView;
import project.transferapi.application.account.AccountViewDetail;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AccountRepository {
    AccountId nextId();

    AccountView findAccountView(AccountQuery query);

    AccountViewDetail findAccountDetailById(AccountId accountId);

    Optional<Account> findAccountById(AccountId id);
}
