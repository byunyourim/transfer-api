package project.transferapi.domain.outbox;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.transferapi.domain.transfer.TransferEventType;
import project.transferapi.domain.transfer.TransferId;

import java.time.LocalDateTime;

import static project.transferapi.domain.outbox.EventStatus.*;

@Entity
@Table( name = "TB_TRANSFER_OUTBOX" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class TransferOutbox {
    @EmbeddedId
    private TransferOutboxId id;
    /* 이체 ID */
    private TransferId transferId;
    /* 이벤트 타입 */
    private TransferEventType eventType;
    /* 이벤트 payload */
    @Column(columnDefinition = "TEXT")
    private String payload;
    /* 이벤트 상태 */
    private EventStatus status;
    /* 생성일시 */
    private LocalDateTime createdAt;
    /* 발행일시 */
    private LocalDateTime publishedAt;
    /* 재시도 횟수 */
    private Integer retryCount;

    /**
     * outbox 이벤트 생성
     * @param id outboxevent ID
     * @param transferId 이체 ID
     * @param eventType 이체 이벤트 유형
     * @param payload 페이로드
     * @return TransferOutboxEvent
     */
    public static TransferOutbox of(TransferOutboxId id, TransferId transferId, TransferEventType eventType, String payload) {
        TransferOutbox event = new TransferOutbox();
        event.id = id;
        event.transferId = transferId;
        event.eventType = eventType;
        event.payload = payload;
        event.status = PENDING;
        event.createdAt = LocalDateTime.now();
        event.publishedAt = null;
        event.retryCount = 0;

        return event;
    }

    /**
     * 발행 완료 처리
     */
    public void checkAsSent() {
        this.status = SENT;
        this.publishedAt = LocalDateTime.now();
    }

    /**
     * 발행 실패 처리
     */
    public void checkAsFailed() {
        this.status = FAILED;
        this.retryCount++;
    }

    /**
     * 재시도 가능 여부
     * @return boolean
     */
    public boolean canRetry() {
        return this.retryCount < 3;
    }
}
