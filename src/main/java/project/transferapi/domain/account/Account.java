package project.transferapi.domain.account;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;
import project.transferapi.application.account.AccountCreateCommand;

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
    /* 소유자 ID */
    private Long ownerId;
    /* 은행코드 */
    private BankCode code;
    /* 계좌상태 */
    private AccountStatus status;
    /* 잔액 */
    @Column(nullable = false)
    private Long balance;
    /* 1회 이체한도 */
    @Column
    private Long perTransferLimit;
    /* 생성일지 */
    @Column( name = "REG_DT" )
    private LocalDateTime createdAt;

    /**
     * 계좌 생성
     * @param command 계좌 생성 정보
     * @param repo 계좌 repository
     * @return Account
     */
    static Account of( AccountCreateCommand command, AccountRepository repo ) {
        Account account = new Account();
        account.id = repo.nextId();
        account.accountNumber = command.accountNumber();
        account.code = command.code();
        account.status = command.status();
        account.balance = command.balance();
        account.createdAt = command.createdAt();

        return account;
    }


    @Override
    public boolean isNew() {
        return false;
    }
}