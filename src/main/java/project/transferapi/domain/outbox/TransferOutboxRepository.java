package project.transferapi.domain.outbox;

public interface TransferOutboxRepository {
    TransferOutbox save(TransferOutbox outbox);
}