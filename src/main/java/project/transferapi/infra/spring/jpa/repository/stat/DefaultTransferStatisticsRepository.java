package project.transferapi.infra.spring.jpa.repository.stat;

import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.transferapi.application.DateUtil;
import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.fraud.TransferStatisticsRepository;
import project.transferapi.domain.stat.TransferStatistics;
import project.transferapi.domain.stat.TransferStatisticsId;

@Repository
@RequiredArgsConstructor
public class DefaultTransferStatisticsRepository implements TransferStatisticsRepository {
    private final JPQLQueryFactory queryFactory;

    private final TransferStatisticsJPARepository repository;

    /**
     * 이체 통계 ID 조회
     * @return TransferStatisticsId
     */
    @Override
    public TransferStatisticsId nextId() {
        return TransferStatisticsId.of(repository.nextId(DateUtil.nowSequenceDateTimeString()));
    }

    /**
     * 이체 통계 저장
     * @param statistics 통계 정보
     */
    @Override
    public void save(TransferStatistics statistics) {
        repository.save(statistics);
    }

    /**
     * 출금 계좌의 이체 금액 조회
     * @param fromAccountId 출금 계좌 ID
     * @return long
     */
    @Override
    public long findTotalAmountById(AccountId fromAccountId) {
        // TODO 개발 필요
        return 0;
    }
}
