package project.transferapi.domain.outbox;

import org.springframework.stereotype.Repository;

@Repository
public interface TransferOutboxRepository {
    TransferOutbox save(TransferOutbox outbox);
}
