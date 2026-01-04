package project.transferapi.application.account;

import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.account.AccountStatus;

import java.time.LocalDateTime;

public record AccountViewDetail (
        /* 계좌 ID */
        AccountId id,
        /* 계좌 번호 */
        Long accountNumber,
        /* 소유자 ID */
        Long ownerId,
        /* 계좌 상태 */
        AccountStatus status,
        /* 잔액 */
        Long balance,
        /* 계좌 생성일 */
        LocalDateTime createdAt,
        /* 1회 이체 한도 */
        Long perTransferLimit
) {
}
