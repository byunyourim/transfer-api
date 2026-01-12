package project.transferapi.domain.fraud;

import org.springframework.stereotype.Repository;
import project.transferapi.application.fraud.FraudDetectionResult;
import project.transferapi.domain.transfer.TransferStatusHistoryId;

import java.util.List;

@Repository
public interface FraudDetectionHistoryRepository {
    TransferStatusHistoryId nextId();

    void saveAll(List<FraudDetectionResult.FraudDetection> detections);
}
