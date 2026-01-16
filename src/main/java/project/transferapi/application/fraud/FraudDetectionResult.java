package project.transferapi.application.fraud;

import java.util.List;

import static project.transferapi.domain.fraud.SeverityType.HIGH;

public record FraudDetectionResult(
        /* 차단여부 */
        boolean blocked,
        /* 탐지 목록 */
        List<FraudDetection> detections
) {
    public FraudDetectionResult(List<FraudDetection> detections){
        this(getBlocked(detections), detections);
    }

    /**
     * 차단여부 확인
     * @param detections 탐지 목록
     * @return boolean
     */
    private static boolean getBlocked(List<FraudDetection> detections) {
        for(FraudDetection detection : detections) {
            if (detection.severityType().equals(HIGH)) {
                return true;
            }
        }
        return false;
    }
}