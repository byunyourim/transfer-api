package project.transferapi.infra.spring.jpa.repository.event;

import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.transferapi.domain.outbox.TransferOutbox;
import project.transferapi.domain.outbox.TransferOutboxRepository;

@Repository
@RequiredArgsConstructor
public class DefaultTransferOutboxEventRepository implements TransferOutboxRepository {
    private final JPQLQueryFactory queryFactory;

    private final TransferOutboxEventJPARepository repository;

    @Override
    public TransferOutbox save(TransferOutbox event) {
        return repository.save(event);
    }
}
