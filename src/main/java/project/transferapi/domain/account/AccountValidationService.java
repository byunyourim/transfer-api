package project.transferapi.domain.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.transferapi.application.transfer.TransferBadRequestException;

import static project.transferapi.application.ErrorStatus.ACCOUNT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AccountValidationService {
    private final AccountRepository repo;

    /**
     * 계좌 유무 검증
     * @param accountIds 계좌 ID 목록
     */
    public void validAccountInfo(AccountId... accountIds) {
        for (AccountId accountId : accountIds) {
            long count = repo.accountById(accountId);
            if (count > 0) {
                throw new TransferBadRequestException(ACCOUNT_NOT_FOUND);
            }
        }
    }
}