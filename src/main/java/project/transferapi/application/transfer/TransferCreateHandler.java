package project.transferapi.application.transfer;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.transferapi.application.fraud.FraudDetectionResult;
import project.transferapi.domain.account.AccountValidationService;
import project.transferapi.domain.fraud.FraudDetectionService;
import project.transferapi.domain.outbox.TransferCreatedEvent;
import project.transferapi.domain.outbox.TransferOutboxCreateService;
import project.transferapi.domain.transfer.Transfer;
import project.transferapi.domain.transfer.TransferRepository;
import project.transferapi.domain.transfer.TransferValidationService;

import static project.transferapi.application.ErrorStatus.BLOCKED_TRANSFER;

@Component
@Transactional
@RequiredArgsConstructor
public class TransferCreateHandler {
    private final TransferRepository repo;

    private final TransferValidationService validationService;

    private final AccountValidationService accountValidationService;

    private final FraudDetectionService detectionService;

    private final TransferOutboxCreateService outboxCreateService;

    /**
     * 이체 요청
     * @param command 이체 요청 command
     */
    public void createTransfer(TransferCommand command) {
        // 검증
        accountValidationService.validAccountInfo(command.fromAccountId(), command.toAccountId());
        validationService.validTransferAmount(command.fromAccountId(), command.amount());
        // 이상거래 탐지
        FraudDetectionResult detectionResult = detectionService.detect(command);
        if (detectionResult.blocked()) {
            throw new TransferBadRequestException(BLOCKED_TRANSFER);
        }
        // 이체 저장
        Transfer transfer = Transfer.of(command, repo);
        repo.save(transfer);

        // 이벤트 발행? 차단되지는 않았지만 탐지내역이 존재하는 경우 outbox 에 이벤트 저장
        if (!detectionResult.detections().isEmpty()) {
            outboxCreateService.create(new TransferCreatedEvent(transfer));
        }
    }
}