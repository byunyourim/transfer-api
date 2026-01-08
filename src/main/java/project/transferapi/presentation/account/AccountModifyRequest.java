package project.transferapi.presentation.account;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.account.AccountStatus;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter @Setter
public class AccountModifyRequest {
    AccountId id;
    /* 1회 이체한도 */
    Long perTransferLimit;
    /* 하루 이체한도 */
    Long dailyTransferLimit;
    /* 계좌 상태 */
    AccountStatus status;
}