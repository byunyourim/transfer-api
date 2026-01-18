package project.transferapi.application.account;

import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.account.AccountStatus;

public record AccountQuery(
        /* 계좌 ID */
        AccountId id,
        /* 회원 ID */
        Long userId,
        /* 계좌 상태 */
        AccountStatus status
) {
}