package project.transferapi.domain.fraud;

import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.stat.TransferStatistics;
import project.transferapi.domain.stat.TransferStatisticsId;

public interface TransferStatisticsRepository {
    TransferStatisticsId nextId();

    void save(TransferStatistics statistics);

    long findTotalAmountById(AccountId fromAccountId);
}