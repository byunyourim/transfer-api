package project.transferapi.application.stat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import project.transferapi.domain.outbox.TransferCreatedEvent;
import project.transferapi.domain.stat.TransferStatisticsService;

@Component
@RequiredArgsConstructor
public class StatisticsOnTransferCreatedEventHandler {
    private final TransferStatisticsService service;
    /**
     * 이체  요청시 이벤트 핸들러
     * @param event 이체 요청 이벤트 핸들러
     */
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handle(TransferCreatedEvent event) {
        service.create(event);
    }
}
