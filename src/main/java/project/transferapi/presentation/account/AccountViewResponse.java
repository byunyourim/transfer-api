package project.transferapi.presentation.account;

import project.transferapi.domain.account.AccountStatus;

import java.util.List;

public record AccountViewResponse (
        /* 계좌목록 */
        List<Account> accounts
) {
    record Account(
            /* 계좌 ID */
            Long id,
            /* 계좌번호 */
            Long accountNumber,
            /* 계좌상태 */
            AccountStatus status
    ) {
    }
}
