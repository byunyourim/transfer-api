package project.transferapi.domain.stat;

import jakarta.persistence.*;
import lombok.*;
import project.transferapi.domain.account.AccountId;

@Entity
@Builder(access = AccessLevel.PRIVATE)
@Table( name = "TB_TRANSFER_STATISTICS" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class TransferStatistics {
    /* 이체집계 ID */
    @EmbeddedId
    private TransferStatisticsId id;
    /* 이체 연월 */
    private String yearMonth;
    /* 이체 일 */
    private String day;
    /* 이체 시간 */
    private String hour;
    /* 입금계좌 ID */
    private AccountId toAccountId;
    /* 출금계좌 ID */
    private AccountId fromAccountId;
    /* 총 이체금액 */
    private Long totalAmount;
    /* 총 이체 건수 */
    private Long count;

    /**
     * 이체 통계 생성
     * @param toAccountId 입금 계좌 ID
     * @param fromAccountId 출금 계좌 ID
     * @param count 이체 건수
     * @param yyyyMMdd 이체 일자
     * @return TransferStatistics
     */
    public static TransferStatistics of(AccountId toAccountId, AccountId fromAccountId, Long count, String yyyyMMdd) {
        return TransferStatistics.builder()
                                 .yearMonth(yyyyMMdd.substring(0, 6))
                                 .day(yyyyMMdd.substring(6, 8))
                                 .hour(yyyyMMdd.substring(8, 10))
                                 .toAccountId(toAccountId)
                                 .fromAccountId(fromAccountId)
                                 .count(count)
                                 .build();
    }
}