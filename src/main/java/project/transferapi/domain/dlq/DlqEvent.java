package project.transferapi.domain.dlq;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.transferapi.domain.transfer.TransferId;

import java.time.LocalDateTime;

@Entity
@Table( name = "TB_DLQ_EVENT" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class DlqEvent {
    /* DLQ ID */
    @EmbeddedId
    private DlqEventId id;
    /* 이체 ID */
    private TransferId transferId;
    /* 실패 유형 */
    private DlqType type;
    /* 에러코드 */
    private String code;
    /* 에러메시지 */
    private String message;
    /* 재시도여부 */
    private boolean retryable;
    /* 생성일시 */
    private LocalDateTime createdAt;
}
