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
        // 이체 계좌 유무 검증
        accountValidationService.validAccountInfo(command.fromAccountId(), command.toAccountId());
        // 이체 금액 검증
        validationService.validTransferAmount(command.fromAccountId(), command.amount());

        // 이상거래 탐지
        FraudDetectionResult fraudResult = detectionService.detect(command);
        // 탐지 결과에 따른 처리
        if (fraudResult.blocked()) {
            throw new TransferBadRequestException(BLOCKED_TRANSFER, fraudResult.type());
        }
        Transfer transfer = Transfer.of(command, repo);
        repo.save(transfer);

        // 탐지된 경우 (차단되지는 않았지만 의심스러운 경우) Outbox에 이벤트 저장
        if (!fraudResult.detections().isEmpty()) {
            outboxCreateService.create(new TransferCreatedEvent(transfer));
        }
    }
}