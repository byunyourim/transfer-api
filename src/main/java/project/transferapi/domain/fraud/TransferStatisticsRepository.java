package project.transferapi.domain.fraud;

import project.transferapi.domain.account.AccountId;

public interface TransferStatisticsRepository {
    long findTotalAmountById(AccountId fromAccountId);
}