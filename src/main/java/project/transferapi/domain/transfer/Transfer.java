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
@Table( name = "TB_TRANSFER" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class Transfer {
    /* 이체 ID */
    @EmbeddedId
    private TransferId id;
    /* 출금계좌 ID */
    private Long fromId;
    /* 입금계좌 ID */
    private Long toId;
    /* 이체금액 */
    private Long amount;
    /* 요청일시 */
    private LocalDateTime requestedAt;
    /* 이체유형 */
    private TransferType type;
    /* 이체상태 */
    private TransferStatus status;
}
