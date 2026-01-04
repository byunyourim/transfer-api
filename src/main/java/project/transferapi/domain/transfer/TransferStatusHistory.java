package project.transferapi.domain.transfer;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.transferapi.domain.account.AccountId;

import java.time.LocalDateTime;

@Entity
@Table( name = "TB_TRANSFER_STATUS_HISTORY" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class TransferStatusHistory {
    @EmbeddedId
    private TransferHistoryId id;
    /* 이체 ID */
    private TransferId transferId;
    /* 계좌 ID */
    private AccountId accountId;
    /* 이체 금액 */
    private Long amount;
    /* 이벤트 유형 */
    private TransferEventType eventType;
    /* 발생 일시 */
    private LocalDateTime createdAt;
}
