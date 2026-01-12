package project.transferapi.domain.stat;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.transfer.TransferId;

@Entity
@Table( name = "TB_TRANSFER_STATISTICS" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class TransferStatistics {
    /* 이체집계 ID */
    @EmbeddedId
    private TransferStatisticsId id;
    /* 이체 일시 */
    private String transferDateTime;
    /* 입금계좌 ID */
    private AccountId toAccountId;
    /* 출금계좌 ID */
    private AccountId fromAccountId;
    /* 총 이체금액 */
    private Long totalAmount;
}
