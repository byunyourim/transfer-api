package project.transferapi.domain.ledger;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.transferapi.domain.Creator;
import project.transferapi.domain.account.AccountId;
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
    /* 생성자 */
    @Embedded
    private Creator creator;

    /**
     * 출금 원장 생성
     * @param transferId 이체 ID
     * @param fromAccountId 출금 계좌 ID
     * @param toAccountId 입금 계좌 ID
     * @param amount 이체 금액
     * @param beforeBalance 변경 전 잔액
     * @param direction 입출금 구분
     * @param repo 원장 repository
     * @return Ledger
     */
    public static Ledger of(TransferId transferId, AccountId fromAccountId, AccountId toAccountId, Long amount, Long beforeBalance, TransferDirection direction, LedgerRepository repo) {
        Ledger ledger = new Ledger();
        ledger.id = repo.nextId();
        ledger.transferId = transferId;
        ledger.fromId = fromAccountId.getId();
        ledger.toId = toAccountId.getId();
        ledger.direction = direction;
        ledger.amount = amount;
        ledger.beforeBalance = beforeBalance;
        ledger.afterBalance = direction == TransferDirection.WITHDRAW ? beforeBalance - amount : beforeBalance + amount;
        return ledger;
    }
}
