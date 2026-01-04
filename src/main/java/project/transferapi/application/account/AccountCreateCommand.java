package project.transferapi.application.account;

import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.account.AccountStatus;
import project.transferapi.domain.account.BankCode;

import java.time.LocalDateTime;
import java.util.Currency;

public record AccountCreateCommand(
        /* 계좌 ID */
        AccountId accountId,
        /* 계좌 번호 */
        Long accountNumber,
        /* 금액 */
        Long amount,
        /* 은행 코드 */
        BankCode code,
        /* 계좌 상태 */
        AccountStatus status,
        /* 잔액 */
        Long balance,
        /* 단위 */
        Currency currency,
        /* 버전 */
        Long version,
        /* 생성일자 */
        LocalDateTime createdAt
) {
}
