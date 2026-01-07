package project.transferapi.application.account;

import project.transferapi.domain.BankCode;
import project.transferapi.domain.user.UserId;

public record AccountCreateCommand(
        /* 회원 ID */
        UserId userId,
        /* 은행 코드 */
        BankCode bankCode,
        /* 잔액 */
        Long balance
) {
}