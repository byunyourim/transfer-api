package project.transferapi.domain.transfer;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.transferapi.application.fraud.FraudDetectionResult;
import project.transferapi.application.transfer.TransferCommand;
import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.fraud.FraudDetectionHistoryRepository;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table( name = "TB_TRANSFER_STATUS_HISTORY" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class TransferStatusHistory {
    @EmbeddedId
    private TransferStatusHistoryId id;
    /* 이체 ID */
    private TransferId transferId;
    /* 계좌 ID */
    private AccountId accountId;
    /* 이체 금액 */
    private Long amount;
    /* 이벤트 유형 */
    private TransferEventType eventType;
    /* 발생 일시 */
    private LocalDateTime createdAt;

    public static void of(TransferCommand command, List<FraudDetectionResult.FraudDetection> detections, FraudDetectionHistoryRepository repo) {
        detections.forEach( detection -> {
            TransferStatusHistory transferStatusHistory = new TransferStatusHistory();
//            transferStatusHistory.id = repo.nextId();
//            transferStatusHistory.transferId = command.;
//            transferStatusHistory.accountId = ;
//            transferStatusHistory.amount = command.amount();
//            transferStatusHistory.eventType = ;

            repo.saveAll(detections);
        });
    }
}