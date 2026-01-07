package project.transferapi.domain.fraud;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.fraud.rule.FraudDetectionRuleId;
import project.transferapi.domain.transfer.TransferHistoryId;

import java.time.LocalDateTime;

@Entity
@Table( name = "TB_FRAUD_ACTION_HISTORY" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class FraudActionHistory {
    /* 이상 탐지 ID */
    @EmbeddedId
    private FraudActionHistoryId id;
    /* 이체 이력 ID */
    private TransferHistoryId transferHistoryId;
    /* 룰 ID */
    private FraudDetectionRuleId ruleId;
    /* 계좌 ID */
    private AccountId accountId;
    /* 탐지 일시 */
    private LocalDateTime detectedAt;
    /* 실제 값 */
    private Long actualValue;
    /* 기준 값 */
    private Long threshold;
    /* 위험 유형 */
    private SeverityType severityType;
    /* 탐지상태 유형 */
    private DetectionStatusType detectionStatusType;
}
