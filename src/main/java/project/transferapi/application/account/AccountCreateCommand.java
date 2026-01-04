package project.transferapi.application.account;

import project.transferapi.domain.Creator;
import project.transferapi.domain.account.BankCode;
import project.transferapi.domain.user.UserId;

public record AccountCreateCommand(
        /* 회원 ID */
        UserId userId,
        /* 잔액 */
        Long balance,
        /* 은행코드 */
        BankCode bankCode,
        /* 등록자 */
        Creator creator
) {
}
