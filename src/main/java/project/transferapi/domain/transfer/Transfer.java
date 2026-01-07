package project.transferapi.domain.transfer;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.transferapi.application.transfer.TransferCommand;
import project.transferapi.domain.DomainEventPublish;
import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.outbox.TransferCreatedEvent;

import java.time.LocalDateTime;

@Entity
@Table( name = "TB_TRANSFER" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class Transfer {
    /* 이체 ID */
    @EmbeddedId
    private TransferId id;
    /* 출금계좌 ID */
    private AccountId fromAccountId;
    /* 입금계좌 ID */
    private AccountId toAccountId;
    /* 이체금액 */
    private Long amount;
    /* 이체유형 */
    private TransferType type;
    /* 이체상태 */
    private TransferStatus status;
    /* 요청일시 */
    private LocalDateTime requestedAt;

    /**
     * 이체 생성
     * @param command 이체 생성 정보
     * @param repo 이체 repository
     * @return Transfer
     */
    public static Transfer of(TransferCommand command, TransferRepository repo) {
        Transfer transfer = new Transfer();
        transfer.id = repo.nextId();
        transfer.fromAccountId = command.fromAccountId();
        transfer.toAccountId = command.toAccountId();
        transfer.amount = command.amount();
        transfer.type = command.type();
        transfer.status = command.status();
        transfer.requestedAt = LocalDateTime.now();

        // 이벤트 발행
        DomainEventPublish.publish(new TransferCreatedEvent(transfer));

        return transfer;
    }
}