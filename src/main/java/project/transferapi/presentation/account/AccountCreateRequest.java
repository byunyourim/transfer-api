package project.transferapi.presentation.account;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
public class AccountCreateRequest {
    /* 회원 ID */
    Long ownerId;
    /* 잔액 */
    Long balance;
    /* 은행 코드 */
    String bankCode;
}