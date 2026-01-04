package project.transferapi.domain.account;

import project.transferapi.application.account.AccountQuery;
import project.transferapi.application.account.AccountView;
import project.transferapi.application.account.AccountViewDetail;

public interface AccountRepository {
    AccountId nextId();

    AccountView findAccountView(AccountQuery query);

    AccountViewDetail findAccountDetailById(AccountId accountId);
}
