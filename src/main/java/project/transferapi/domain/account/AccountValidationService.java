package project.transferapi.domain.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.transferapi.application.ErrorStatus;
import project.transferapi.application.account.AccountBadRequestException;
import project.transferapi.application.account.AccountCreateCommand;
import project.transferapi.application.account.AccountModifyCommand;
import project.transferapi.application.user.UserBadRequestException;

import static project.transferapi.application.ErrorStatus.*;

@Service
@RequiredArgsConstructor
public class AccountValidationService {
    private final AccountRepository repository;

    private final int MAXIMUM_PER_TRANSFER_LIMIT = 10_000_000;

    private final int MAXIMUM_DAILY_TRANSFER_LIMIT = 100_000_000;

    /**
     * 계좌 생성시 정보 검증
     * @param command 계좌 생성 정보
     */
    public void validAccountInfo(AccountCreateCommand command) {
        if (command.userId() == null) {
            throw new UserBadRequestException(ErrorStatus.USER_NOT_FOUND);
        }
        if (command.balance() == null || command.balance() <= 0) {
            throw new AccountBadRequestException(ErrorStatus.INVALID_ACCOUNT_BALANCE);
        }
    }

    /**
     * 계좌 수정시 정보 검증
     * - 1회 이체한도
     * - 하루 이체한도
     * @param command 계좌 수정 정보
     */
    public void validAccountInfo(AccountModifyCommand command) {
        if (command.perTransferLimit() < 0 || command.perTransferLimit() > MAXIMUM_PER_TRANSFER_LIMIT) {
            throw new AccountBadRequestException(PER_TRANSFER_LIMIT_INVALID, MAXIMUM_PER_TRANSFER_LIMIT);
        }
        if (command.dailyTransferLimit() < 0 || command.dailyTransferLimit() > MAXIMUM_DAILY_TRANSFER_LIMIT) {
            throw new AccountBadRequestException(DAILY_TRANSFER_LIMIT_INVALID, MAXIMUM_DAILY_TRANSFER_LIMIT);
        }
    }
}
