package project.transferapi.presentation.account;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import project.transferapi.domain.account.AccountStatus;

@FieldDefaults( level = AccessLevel.PRIVATE )
@Getter @Setter
public class AccountViewRequest {
    Long owenerId;
    AccountStatus status;
}
