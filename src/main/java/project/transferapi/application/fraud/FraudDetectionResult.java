package project.transferapi.application.fraud;

import project.transferapi.domain.fraud.SeverityType;
import project.transferapi.domain.fraud.rule.FraudDetectionRule;

import java.util.List;

public record FraudDetectionResult(
        /* 이상 탐지 리스트 */
        List<FraudDetection> detections,
        /* 위험도 */
        SeverityType type,
        /* 차단 여부 */
        boolean blocked
) {
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
    /**
     * 이상 탐지 결과 생성
     * @param detections 탐지내역
     * @return FraudDetectionResult
     */
    public static FraudDetectionResult of(List<FraudDetection> detections) {
        if (detections.isEmpty()) {
            return new FraudDetectionResult(List.of(), null, false);
        }
        SeverityType maxSeverity = detections.stream()
                                             .map(FraudDetection::severityType)
                                             .max(FraudDetectionResult::compareSeverity)
                                             .orElse(SeverityType.LOW);

        return new FraudDetectionResult(detections, maxSeverity, maxSeverity == SeverityType.HIGH);
    }

    private static int compareSeverity(SeverityType s1, SeverityType s2) {
        int order1 = s1 == SeverityType.LOW ? 1 : s1 == SeverityType.MEDIUM ? 2 : 3;
        int order2 = s2 == SeverityType.LOW ? 1 : s2 == SeverityType.MEDIUM ? 2 : 3;
        return Integer.compare(order1, order2);
    }
}




