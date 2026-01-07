package project.transferapi.presentation.account;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import project.transferapi.domain.account.AccountStatus;

@FieldDefaults( level = AccessLevel.PRIVATE )
@Getter @Setter
public class AccountViewRequest {
    /* 회원 ID */
    Long userId;
    /* 계좌 상태 */
    AccountStatus status;
}
