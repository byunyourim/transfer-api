package project.transferapi.application.account;

import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.account.AccountStatus;
import project.transferapi.domain.user.UserId;

import java.time.LocalDateTime;

public record AccountViewDetail (
        /* 계좌 ID */
        AccountId id,
        /* 계좌 번호 */
        Long accountNumber,
        /* 회원 ID */
        UserId userId,
        /* 계좌 상태 */
        AccountStatus status,
        /* 잔액 */
        Long balance,
        /* 계좌 생성일 */
        LocalDateTime createdAt,
        /* 1회 이체 한도 */
        Long perTransferLimit,
        /* 하루 이체 한도 */
        Long dailyTransferLimit
) {
}
