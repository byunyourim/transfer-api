package project.transferapi.application.outbox;

import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import project.transferapi.domain.outbox.TransferCreatedEvent;
import project.transferapi.domain.outbox.TransferOutboxCreateService;

@Component
@RequiredArgsConstructor
public class TransferOutboxOnTransferCreatedEventHandler {
    private final TransferOutboxCreateService transferOutboxCreateService;

    /**
     * 이체 요청시 이벤트 핸들러
     * @param event 이체 요청 이벤트 핸들러
     */
    @Order(1)
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void createTransferOutbox(TransferCreatedEvent event) {
        // outbox repository 에 저장
        transferOutboxCreateService.create(event);
    }
}
