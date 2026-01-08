package project.transferapi.presentation.account;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import project.transferapi.domain.account.AccountStatus;
import project.transferapi.domain.account.BankCode;

@FieldDefaults( level = AccessLevel.PRIVATE )
@Getter @Setter
public class AccountViewDetailResponse {
    /* 계좌 ID */
    private Long id;
    /* 계좌번호 */
    private Long accountNumber;
    /* 회원 ID */
    private Long userId;
    /* 은행코드 */
    private BankCode code;
    /* 계좌상태 */
    private AccountStatus status;
    /* 잔액 */
    private Long balance;
    /* 1회 이체한도 */
    private Long perTransferLimit;
    /* 하루 이체한도 */
    private Long dailyTransferLimit;
}