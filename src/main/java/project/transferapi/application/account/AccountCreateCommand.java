package project.transferapi.application.account;

import project.transferapi.domain.account.BankCode;
import project.transferapi.domain.user.UserId;

import java.time.LocalDateTime;

public record AccountCreateCommand(
        /* 은행 코드 */
        BankCode code,
        /* 잔액 */
        Long balance,
        /* 1회 이체한도 */
        Long perTransferLimit,
        /* 하루 이체 한도 */
        Long dailyTransferLimit,
        /* 생성일자 */
        LocalDateTime createdAt,
        /* 회원 ID */
        UserId userId
) {
}
