package project.transferapi.application.fraud;

import project.transferapi.domain.fraud.SeverityType;
import project.transferapi.domain.fraud.rule.FraudDetectionRule;

public record FraudDetection(
        /* 탐지여부 */
        boolean detected,
        /* 이상 탐지 룰 */
        FraudDetectionRule rule,
        /* 실제값 */
        long actualValue,
        /* 임계값 */
        long threshold,
        /* 위험도 */
        SeverityType severityType
) {
}