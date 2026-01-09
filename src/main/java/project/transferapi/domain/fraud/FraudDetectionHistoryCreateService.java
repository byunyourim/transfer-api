package project.transferapi.domain.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.transferapi.application.fraud.FraudDetection;
import project.transferapi.application.transfer.TransferCommand;
import project.transferapi.domain.transfer.TransferStatusHistory;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FraudDetectionHistoryCreateService {
    private final FraudDetectionHistoryRepository repo;

    /**
     * 탐지 이력 생성
     * @param command 이체 정보 command
     * @param detections 이상 탐지 목록
     */
    public void create(TransferCommand command, List<FraudDetection> detections) {
        TransferStatusHistory.of(command, detections, repo);
    }
}