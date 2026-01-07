package project.transferapi.application.account;

import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.account.AccountStatus;

public record AccountModifyCommand(
        /* 계좌 ID */
        AccountId id,
        /* 1회 이체한도 */
        Long perTransferLimit,
        /* 하루 이체한도 */
        Long dailyTransferLimit,
        /* 계좌 상태 */
        AccountStatus status
) {
}
