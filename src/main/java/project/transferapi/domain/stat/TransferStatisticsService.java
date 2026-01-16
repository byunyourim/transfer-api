package project.transferapi.domain.stat;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.transferapi.domain.outbox.TransferCreatedEvent;
import project.transferapi.domain.outbox.TransferOutbox;
import project.transferapi.domain.transfer.TransferEventType;
import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class TransferStatisticsService {
    private final ObjectMapper objectMapper;

    /**
     * transfer 통계 생성
     * @param event 이벤트
     */
    public void create(TransferCreatedEvent event) {

        TransferStatistics statistics = TransferStatistics.of();
    }
}
