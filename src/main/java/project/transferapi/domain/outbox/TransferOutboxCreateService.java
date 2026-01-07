package project.transferapi.domain.outbox;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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
            // 이벤트를 JSON으로 변환
            String payload = objectMapper.writeValueAsString(event);

            // Outbox 생성
            TransferOutbox outbox = TransferOutbox.of(
                    repository.nextId(),
                    event.transferId(),
                    TransferEventType.REQUESTED,
                    payload
            );

            // 저장
            repository.save(outbox);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize event", e);
        }
    }
}
