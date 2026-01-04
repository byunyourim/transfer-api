package project.transferapi.application.account;

import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.account.AccountStatus;

public record AccountQuery(
    AccountId accountId,
    Long accountNumber,
    Long ownerId,
    AccountStatus status
) {
}