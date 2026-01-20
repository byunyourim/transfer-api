package project.transferapi.domain.fraud;

import project.transferapi.application.fraud.FraudDetection;
import project.transferapi.domain.transfer.TransferStatusHistoryId;

import java.util.List;

public interface FraudDetectionHistoryRepository {
    TransferStatusHistoryId nextId();

    void saveAll(List<FraudDetection> detections);
}