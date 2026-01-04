package project.transferapi.presentation.account;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
public class AccountCreateRequest {
    /* 소유자 ID */
    Long userId;
    /* 잔액 */
    Long balance;
    /* 은행코드 */
    Long bankCode;
}
