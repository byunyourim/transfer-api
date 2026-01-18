package project.transferapi.domain.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.transferapi.domain.account.AccountId;

@Service
@RequiredArgsConstructor
public class TransferStatisticsService {
    private final TransferStatisticsRepository repo;

    /**
     * 출금계좌의 당일 이체금액 조회
     * @param accountId 출금 계좌
     * @return long
     */
    public long getTotalAmount(AccountId accountId) {
        return repo.findTotalAmountById(accountId);
    }
}
