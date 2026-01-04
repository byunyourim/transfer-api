package project.transferapi.application.account;

import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.account.AccountStatus;

import java.util.List;

public record AccountView(
        /* 계좌 목록 갯수 */
        long count,
        /* 계좌 목록 */
        List<Account> accounts
) {
    public record Account(
            /* 계좌 ID */
            AccountId id,
            /* 계좌 번호 */
            Long accountNumber,
            /* 계좌 상태 */
            AccountStatus status
    ) {
    }
}
