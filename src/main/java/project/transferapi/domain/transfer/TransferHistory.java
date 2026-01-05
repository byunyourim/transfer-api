package project.transferapi.domain.transfer;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table( name = "TB_TRANSFER_HISTORY" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class TransferHistory {
    @EmbeddedId
    private TransferHistoryId id;
    /* 이체 ID */
    private TransferId transferId;
    /* 계좌 ID */
    private Long accountId;
    /* 이체 금액 */
    private Long amount;
    /* 이벤트 유형 */
    private TransferEventType eventType;
    /* 발생 일시 */
    private LocalDateTime createdAt;
}
