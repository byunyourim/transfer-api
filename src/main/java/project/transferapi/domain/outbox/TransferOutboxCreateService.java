package project.transferapi.domain.outbox;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.transferapi.application.fraud.FraudDetectionResult;
import project.transferapi.application.transfer.TransferCommand;
import project.transferapi.domain.transfer.TransferEventType;
import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class TransferOutboxCreateService {
    private final TransferOutboxRepository repository;

    private final ObjectMapper objectMapper;

    /**
     * transfer Outbox 생성
     * @param event 이벤트
     */
    public void create(TransferCreatedEvent event) {
        try {
            String payload = objectMapper.writeValueAsString(event);
            TransferOutbox outbox = TransferOutbox.of(event.transferId(), TransferEventType.REQUESTED, payload);
            repository.save(outbox);

        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize event", e);
        }
    }

    /**
     * transfer Outbox 생성
     * @param command command 정보
     * @param detectionResult 탐지 결과
     */
    public void create(TransferCommand command, FraudDetectionResult detectionResult) {
        String payload = objectMapper.writeValueAsString(command);
        TransferOutbox outbox = TransferOutbox.of(command.transferId(), TransferEventType.REQUESTED, payload);
        repository.save(outbox);
    }
}
