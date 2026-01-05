package project.transferapi.domain.fraud.rule;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.transferapi.domain.fraud.RuleType;
import project.transferapi.domain.fraud.SeverityType;

@Entity
@Table( name = "TB_FRAUD_RULE" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class FraudDetectionRule {
    /* 룰 ID */
    @EmbeddedId
    private FraudDetectionRuleId id;
    /* 이름*/
    private String name;
    /* 룰 유형 */
    private RuleType type;
    /* 임계값 */
    private Long threshold;
    /* 구간 */
    private Long window;
    /* 이상 유형 */
    private SeverityType severityType;
    /* 활성 여부 */
    @Column(name = "USE_FLAG")
    private boolean enabled;
}
