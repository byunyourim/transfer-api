package project.transferapi.domain.ledger;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "TB_LEDGER" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class Ledger {
    /* 원장 ID */
    @EmbeddedId
    private LedgerId id;
    /* 계좌 ID */
    private Long accountId;
    /* 증감금액 */
    private Long deltaAmount;
    /* 변경전 잔액 */
    private Long beforeBalance;
    /* 변경후 잔액 */
    private Long afterBalance;
    /* 변경 사유 */
    private LedgerType reason;
    /* 참조 ID */
    /* 생성일시 */
    /* 생성일시 */


}
