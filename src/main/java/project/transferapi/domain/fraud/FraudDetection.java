package project.transferapi.domain.fraud;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.transferapi.domain.fraud.rule.FraudDetectionRuleId;
import project.transferapi.domain.transfer.TransferHistory;
import project.transferapi.domain.transfer.TransferHistoryId;

import java.time.LocalDateTime;

@Entity
@Table( name = "TB_FRAUD_DETECTION" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class FraudDetection {
    /* 이상 탐지 ID */
    @EmbeddedId
    private FraudDetectionId id;
    /* 이체 이력 ID */
    private TransferHistoryId transferHistoryId;
    /* 룰 ID */
    private FraudDetectionRuleId ruleId;
    /* 계좌 ID */
    private Long accountId;
    /* 탐지 일시 */
    private LocalDateTime detectedAt;
    /* 실제 값 */
    private Long actualValue;
    /* 기준 값 */
    private Long threshold;
    /* 위험 유형 */
    private SeverityType severityType;
    /* 탐지 유형 */
    private DetectionType detectionType;
}
