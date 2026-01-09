package project.transferapi.domain.fraud;

import org.springframework.stereotype.Repository;
import project.transferapi.application.fraud.FraudDetection;
import project.transferapi.domain.transfer.TransferStatusHistoryId;

import java.util.List;

@Repository
public interface FraudDetectionHistoryRepository {
    TransferStatusHistoryId nextId();

    void saveAll(List<FraudDetection> detections);
}