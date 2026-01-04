package project.transferapi.presentation;

import project.transferapi.domain.account.AccountId;

public interface VOMapper {
    default AccountId toAccountId(Long id) {
        return AccountId.of(id);
    }

    default Long toLong(AccountId id) {
        return id == null ? null : id.getId();
    }
}
