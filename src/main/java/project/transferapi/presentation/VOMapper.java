package project.transferapi.presentation;

import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.transfer.TransferId;
import project.transferapi.domain.user.UserId;

public interface VOMapper {
    default AccountId toAccountId(Long id) {
        return AccountId.of(id);
    }

    default Long toLong(AccountId id) {
        return id == null ? null : id.getId();
    }

    default UserId toUserId(Long id) {
        return UserId.of(id);
    }

    default Long toLong(UserId id) {
        return id == null ? null : id.getId();
    }

    default TransferId toTransferId(Long id) {
        return TransferId.of(id);
    }

    default Long toLong(TransferId id) {
        return id == null ? null : id.getId();
    }
}
