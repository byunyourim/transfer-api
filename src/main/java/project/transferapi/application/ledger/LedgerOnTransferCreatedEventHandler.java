package project.transferapi.application.ledger;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import project.transferapi.application.account.AccountViewDetail;
import project.transferapi.domain.account.AccountRepository;
import project.transferapi.domain.ledger.Ledger;
import project.transferapi.domain.ledger.LedgerRepository;
import project.transferapi.domain.ledger.TransferDirection;
import project.transferapi.domain.outbox.TransferCreatedEvent;

@Component
@RequiredArgsConstructor
public class LedgerOnTransferCreatedEventHandler {
    private final LedgerRepository repository;

    private final AccountRepository accountRepository;

    /**
     * 이체 생성 이벤트 핸들러
     * @param event 이체 생성 이벤트
     */
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handle(TransferCreatedEvent event) {
        // 입/출금 계좌 잔액 조회
        AccountViewDetail fromAccount = accountRepository.findAccountDetailById(event.fromAccountId());
        AccountViewDetail toAccount = accountRepository.findAccountDetailById(event.toAccountId());
        // 입금 원장 등록
        Ledger withdrawLedger = Ledger.of(event.transferId(), event.fromAccountId(), event.toAccountId(), event.amount(), fromAccount.balance(), TransferDirection.WITHDRAW, repository);
        repository.save(withdrawLedger);
        // 출금 원장 등록
        Ledger depositLedger = Ledger.of(event.transferId(), event.fromAccountId(), event.toAccountId(), event.amount(), toAccount.balance(), TransferDirection.DEPOSIT, repository);
        repository.save(depositLedger);
    }
}