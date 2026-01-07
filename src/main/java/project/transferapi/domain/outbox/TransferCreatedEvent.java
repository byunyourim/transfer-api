package project.transferapi.domain.outbox;

import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.transfer.Transfer;
import project.transferapi.domain.transfer.TransferId;
import project.transferapi.domain.transfer.TransferStatus;
import project.transferapi.domain.transfer.TransferType;

import java.time.LocalDateTime;

public record TransferCreatedEvent(
        /* 이체 ID */
        TransferId transferId,
        /* 출금 계좌 ID */
        AccountId fromAccountId,
        /* 이체 계좌 ID */
        AccountId toAccountId,
        /* 이체 금액 */
        Long amount,
        /* 이체 유형 */
        TransferType type,
        /* 이체 상태 */
        TransferStatus status,
        /* 이체 요청 일자 */
        LocalDateTime requestedAt
) {
    public TransferCreatedEvent(Transfer transfer) {
        this(transfer.getId(), transfer.getFromAccountId(), transfer.getToAccountId(), 
             transfer.getAmount(), transfer.getType(), transfer.getStatus(), transfer.getRequestedAt());        
    }
}
