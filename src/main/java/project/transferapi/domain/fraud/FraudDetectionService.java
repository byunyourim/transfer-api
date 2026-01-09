package project.transferapi.domain.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.transferapi.application.fraud.FraudDetection;
import project.transferapi.application.transfer.TransferCommand;
import project.transferapi.domain.fraud.rule.FraudDetectionRule;
import project.transferapi.domain.fraud.rule.FraudDetectionRuleRepository;
import project.transferapi.domain.fraud.rule.ThresholdRange;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static project.transferapi.domain.fraud.RuleType.*;
import static project.transferapi.domain.fraud.rule.TermType.*;

/**
 * 이상 탐지 Service
 */
@Service
@RequiredArgsConstructor
public class FraudDetectionService {
    private final FraudDetectionRuleRepository ruleRepository;

    private final FraudDetectionHistoryRepository historyRepository;

    private final FraudDetectionHistoryCreateService historyCreateService;

    private final TransferStatisticsService statisticsService;

    /**
     * 이상 탐지
     * @param command 이체 요청 정보
     * @return FraudDetectionResult
     */
    public List<FraudDetection> detect(TransferCommand command) {
        // 활성화된 탐지 룰 목록 조회
        List<FraudDetectionRule> rules = ruleRepository.findAllByEnabledTrue();

        // 이체 요청 정보에 각 룰 적용 -> 위반하는 룰이 있는 경우 detections 에 추가
        List<FraudDetection> detections = new ArrayList<>();
        for (FraudDetectionRule rule : rules) {
            FraudDetection detection = applyRule(command, rule);
            if (detection != null && detection.detected()) {
                detections.add(detection);
            }
        }
        // 탐지 결과 생성
        List<FraudDetection> result = List.of();
        // 탐지 내역이 존재하는 경우 -> 탐지 이력 저장
        if (!detections.isEmpty()) {
            saveDetectionHistory(command, detections);
        }
        return result;
    }

    /**
     * 룰 적용
     * @param command 이상 탐지 정보
     * @param ruleType 룰 정보
     * @return FraudDetection
     */
    public FraudDetection applyRule(TransferCommand command, FraudDetectionRule ruleType) {
        return switch (ruleType.getType()) {
            case AMOUNT -> applyAmountRule(command);
            case COUNT -> applyCountRule(command);
            case VELOCITY -> applyVelocityRule(command);
        };
    }

    /**
     * 이상 금액 탐지 룰
     * @param command 이체 정보
     * @return FraudDetection
     */
    private FraudDetection applyAmountRule(TransferCommand command) {
        // 단일 이체 금액 검증
        long amount = command.amount();
        FraudDetectionRule perAmountRule = ruleRepository.findByTypeAndTermType(AMOUNT, PER);
        if (command.amount() > perAmountRule.getThreshold()) {
            return new FraudDetection(true, perAmountRule, amount, perAmountRule.getThreshold(), perAmountRule.getSeverityType());
        }
        // 일일 누적 이체 금액 검증
        long totalAmount = statisticsService.getTotalAmount(command.fromAccountId());
        FraudDetectionRule dayAmountRule = ruleRepository.findByTypeAndTermType(AMOUNT, DAY);
        if (totalAmount > dayAmountRule.getThreshold()) {
            return new FraudDetection(true, dayAmountRule, amount, dayAmountRule.getThreshold(), dayAmountRule.getSeverityType());
        }
        return new FraudDetection(false, null, amount, 0L, null);
    }

    /**
     * 이상 횟수 탐지 룰
     * @param command 이체 정보
     * @return FraudDetection
     */
    private FraudDetection applyCountRule(TransferCommand command) {
        // 단시간에 반복되는 이체 탐지
        FraudDetectionRule rule = ruleRepository.findByTypeAndTermType(COUNT, MINUTE);
        ThresholdRange range = rule.getRange();
        long min = range.getMin();
        LocalDateTime start = LocalDateTime.now().minusMinutes(min);

        // 10분 이내 동일 계좌로 5회 - HIGH

        // 1시간 이내 이체 횟수 20회 - MEDIUM

        // 1일 출금 계좌 이체 건수 50회 - LOW

        return null;
    }

    /**
     * 이상 속도 탐지 룰
     * @param command 이체 정보
     * @return FraudDetection
     */
    private FraudDetection applyVelocityRule(TransferCommand command) {
        // 이체 패턴 변화 속도

        return null;
    }

    /**
     * 탐지 이력 저장
     * @param command 이체 정보
     * @param detections 탐지 결과 리스트
     */
    private void saveDetectionHistory(TransferCommand command, List<FraudDetection> detections) {
        historyCreateService.create(command, detections);
    }
}