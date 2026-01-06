package project.transferapi.domain.ledger;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.transferapi.domain.stat.TransferStatisticsId;
import project.transferapi.domain.transfer.TransferId;

import java.time.LocalDateTime;

@Entity
@Table( name = "TB_LEDGER" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class Ledger {
    /* 원장 ID */
    @EmbeddedId
    private LedgerId id;
    /* 이체 ID */
    private TransferId transferId;
    /* 출금 계좌 ID */
    private Long fromId;
    /* 송금 계좌 ID */
    private Long toId;
    /* 이체 유형 */
    private TransferDirection direction;
    /* 금액 */
    private Long amount;
    /* 변경전 잔액 */
    private Long beforeBalance;
    /* 변경후 잔액 */
    private Long afterBalance;
    /* 생성일시 */
    private LocalDateTime createdAt;
}
