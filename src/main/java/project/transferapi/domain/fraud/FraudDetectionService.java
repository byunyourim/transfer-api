package project.transferapi.domain.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.transferapi.application.fraud.FraudDetectionResult;
import project.transferapi.application.transfer.TransferCommand;
import project.transferapi.domain.fraud.rule.FraudDetectionRule;
import project.transferapi.domain.fraud.rule.FraudDetectionRuleRepository;
import project.transferapi.domain.fraud.rule.ThresholdRange;

import java.util.ArrayList;
import java.util.List;

/**
 * 이상 탐지 Service
 */
@Service
@RequiredArgsConstructor
public class FraudDetectionService {
    private final FraudDetectionRuleRepository ruleRepository;

    private final FraudDetectionHistoryRepository historyRepository;

    private final TransferStatisticsService statisticsService;

    /**
     * 이상 탐지
     * @param command 이체 요청 정보
     * @return FraudDetectionResult
     */
    public FraudDetectionResult detect(TransferCommand command) {
        // 활성화된 탐지 룰 목록
        List<FraudDetectionRule> rules = ruleRepository.findAllByEnabledTrue();

        // 이체 요청 정보에 각 룰 적용 -> 위반하는 룰이 있는 경우 detections 에 추가
        List<FraudDetectionResult.FraudDetection> detections = new ArrayList<>();
        for (FraudDetectionRule rule : rules) {
            FraudDetectionResult.FraudDetection detection = applyRule(command, rule);
            if (detection != null && detection.detected()) {
                detections.add(detection);
            }
        }
        // 탐지 결과 생성
        FraudDetectionResult result = FraudDetectionResult.of(detections);
        // 탐지 내역이 존재하는 경우 -> 탐지 이력 저장
        if (!detections.isEmpty()) {
            saveDetectionHistory(command, detections);
        }
        return result;
    }

    /**
     * 탐지 이력 저장
     * @param command 이체 정보
     * @param detections 탐지 결과 리스트
     */
    private void saveDetectionHistory(TransferCommand command, List<FraudDetectionResult.FraudDetection> detections) {
        // TODO: FraudDetectionHistory 엔티티 생성 및 저장 로직 구현
        // 현재는 transferHistoryId가 필요한데, 이체 히스토리 생성 시점에 따라 구현 필요
    }

    /**
     * 룰 적용
     * @param command 이상 탐지 정보
     * @param ruleType 룰 정보
     * @return FraudDetection
     */
    public FraudDetectionResult.FraudDetection applyRule(TransferCommand command, FraudDetectionRule ruleType) {
        return switch (ruleType.getType()) {
            case AMOUNT -> applyAmountRule(command, ruleType);
            case COUNT -> applyCountRule(command, ruleType);
            case VELOCITY -> applyVelocityRule(command, ruleType);
        };
    }

    /**
     * 이상 금액 탐지 룰
     * @param command 이체 정보
     * @param ruleType 룰 유형
     * @return FraudDetection
     */
    public FraudDetectionResult.FraudDetection applyAmountRule(TransferCommand command, FraudDetectionRule ruleType) {
        // TODO 이체 금액 탐지 규칙 확인
        long amount = command.amount();
        ThresholdRange range = ruleType.getRange();


        return null;
    }

    /**
     * 이상 횟수 탐지 룰
     * @param command 이체 정보
     * @param ruleType 룰 유형
     * @return FraudDetection
     */
    public FraudDetectionResult.FraudDetection applyCountRule(TransferCommand command, FraudDetectionRule ruleType) {
        // TODO 이체 횟수 탐지 규칙 확인
        return null;
    }

    /**
     * 이상 속도 탐지 룰
     * @param command 이체 정보
     * @param ruleType 룰 유형
     * @return FraudDetection
     */
    public FraudDetectionResult.FraudDetection applyVelocityRule(TransferCommand command, FraudDetectionRule ruleType) {
        // TODO 이체 속도 탐지 규칙 확인
        return null;
    }
}
