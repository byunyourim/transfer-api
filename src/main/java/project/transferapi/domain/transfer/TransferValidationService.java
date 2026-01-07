package project.transferapi.domain.transfer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.transferapi.application.account.AccountsNotFoundException;
import project.transferapi.application.transfer.TransferBadRequestException;
import project.transferapi.domain.account.Account;
import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.account.AccountRepository;

import static project.transferapi.application.ErrorStatus.*;

@Service
@RequiredArgsConstructor
public class TransferValidationService {
    private final TransferRepository repo;

    private final AccountRepository accountRepository;

    /**
     * 이체 금액 검증
     * @param id 출금계좌 ID
     * @param transferAmount 이체금액
     */
    public void validTransferAmount(AccountId id, Long transferAmount) {
        Account account = accountRepository.findAccountById(id)
                                           .orElseThrow(() -> new AccountsNotFoundException(ACCOUNT_NOT_FOUND));
        if (transferAmount > account.getPerTransferLimit()) {
            throw new TransferBadRequestException(PER_TRANSFER_LIMIT_EXCEED);
        }
    }
}
