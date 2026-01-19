package project.transferapi.application.transfer;

import project.transferapi.domain.Creator;
import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.transfer.TransferId;
import project.transferapi.domain.transfer.TransferStatus;
import project.transferapi.domain.transfer.TransferType;

import java.time.LocalDateTime;

public record TransferCommand(
        /* 이체 ID */
        TransferId transferId,
        /* 출금계좌 ID */
        AccountId fromAccountId,
        /* 입금계좌 ID */
        AccountId toAccountId,
        /* 이체 금액 */
        Long amount,
        /* 일일 누적 금액 */
        Long totalAmount,
        /* 이체 유형 */
        TransferType type,
        /* 이체 상태 */
        TransferStatus status,
        /* 이체 요청 시간 */
        LocalDateTime requestedAt,
        /* 등록자 */
        Creator creator
) {
}