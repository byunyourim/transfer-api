package project.transferapi.presentation.transfer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import project.transferapi.domain.transfer.TransferStatus;
import project.transferapi.domain.transfer.TransferType;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
public class TransferCreateRequest {
    /* 출금계좌 ID */
    Long fromAccountId;
    /* 입금계좌 ID */
    Long toAccountId;
    /* 이체 금액 */
    Long amount;
    /* 이체 유형 */
    TransferType type;
    /* 이체 상태 */
    TransferStatus status;
}