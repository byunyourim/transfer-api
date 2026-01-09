package project.transferapi.infra.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.transferapi.domain.outbox.EventStatus;
import project.transferapi.domain.outbox.TransferOutbox;
import project.transferapi.domain.outbox.TransferOutboxId;

import java.util.List;

public interface TransferOutboxEventJPARepository
    extends JpaRepository<TransferOutbox, TransferOutboxId> {

    /**
     * 상태별 이벤트 조회 (생성일시 오름차순)
     * @param status 이벤트 상태
     * @return List<TransferOutbox>
     */
    List<TransferOutbox> findByStatusOrderByCreatedAtAsc(EventStatus status);

    /**
     * 재시도 가능한 실패 이벤트 조회
     * @return List<TransferOutbox>
     */
    @Query("SELECT e FROM TransferOutbox e " +
           "WHERE e.status = 'FAILED' AND e.retryCount < 3 " +
           "ORDER BY e.createdAt ASC")
    List<TransferOutbox> findRetryableFailedEvents();
}
