package project.transferapi.domain.account;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;
import project.transferapi.application.account.AccountCreateCommand;
import project.transferapi.domain.BankCode;

import java.time.LocalDateTime;

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
    private Long userId;
    /* 은행코드 */
    private BankCode bankCode;
    /* 계좌상태 */
    private AccountStatus status;
    /* 잔액 */
    @Column(nullable = false)
    private Long balance;
    /* 1회 이체한도 */
    private Long perTransferLimit;
    /* 생성일지 */
    @Column( name = "REG_DT" )
    private LocalDateTime createdAt;

    private Long version;

    /**
     * 계좌 생성
     * @param command 계좌 생성 정보
     * @param repo 계좌 repository
     * @return Account
     */
    public static Account of( AccountCreateCommand command, AccountRepository repo ) {
        Account account = new Account();
        account.id = repo.nextId();
        account.accountNumber = 1L;
        account.bankCode = command.bankCode();
        account.status = AccountStatus.ACTIVE;
        account.balance = command.balance();

        return account;
    }


    @Override
    public boolean isNew() {
        return false;
    }
}