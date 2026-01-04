package project.transferapi.domain.account;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;
import project.transferapi.application.ErrorStatus;
import project.transferapi.application.account.AccountBadRequestException;
import project.transferapi.application.account.AccountCreateCommand;
import project.transferapi.domain.Creator;
import project.transferapi.domain.Modifier;
import project.transferapi.domain.user.UserId;


import static project.transferapi.domain.account.AccountStatus.SUSPENDED;
import static project.transferapi.domain.account.AccountStatus.TERMINATED;

@Entity
@Table( name = "TB_ACCOUNTS" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class Account implements Persistable< AccountId > {
    /* 계좌 ID */
    @EmbeddedId
    private AccountId id;
    /* 계좌번호 */
    private Long accountNumber;
    /* 회원 ID */
    private UserId userId;
    /* 은행 코드 */
    private BankCode bankCode;
    /* 계좌상태 */
    private AccountStatus status;
    /* 잔액 */
    @Column(nullable = false)
    private Long balance;
    /* 1회 이체한도 */
    private Long perTransferLimit;
    /* 하루 이체한도 */
    private Long dailyTransferLimit;
    /* 버전 */
    private Long version;
    /* 등록자 */
    @Embedded
    private Creator creator;
    /* 수정자 */
    @Embedded
    private Modifier modifier;
    @Override
    public boolean isNew() {
        return false;
    }

    /**
     * 계좌 생성
     * @param command 계좌 생성 정보
     * @param repo 계좌 repository
     * @return Account
     */
    public static Account of(AccountCreateCommand command, AccountRepository repo ) {
        Account account = new Account();
        account.id = repo.nextId();
        account.accountNumber = generateAccountNumber(command.bankCode());
        account.userId = command.userId();
        account.bankCode = command.bankCode();
        account.status = AccountStatus.ACTIVE;
        account.balance = command.balance();
        account.creator = command.creator();

        return account;
    }

    /**
     * 계좌번호 생성
     * @param bankCode 은행코드
     * @return Long
     */
    private static Long generateAccountNumber(BankCode bankCode) {

        return 0L;
    }

    /**
     * 계좌 정보 변경
     * @param perTransferLimit 1회 이체한도
     * @param dailyTransferLimit 하루 이체한도
     */
    public void modify(Long perTransferLimit, Long dailyTransferLimit, AccountStatus status) {
        if (this.status.changeable(status)) {
            throw new AccountBadRequestException(ErrorStatus.CANNOT_CHANGE_ACCOUNT_INFO, this.status);
        }
        this.perTransferLimit = perTransferLimit;
        this.dailyTransferLimit = dailyTransferLimit;
    }
}