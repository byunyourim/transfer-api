package project.transferapi.presentation.account;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults( level = AccessLevel.PRIVATE )
@Getter @Setter
public class AccountCreateResponse {
    /* 계좌번호 */
    Long AccountNumber;
}
