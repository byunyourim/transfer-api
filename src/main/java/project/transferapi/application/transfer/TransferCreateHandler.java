package project.transferapi.application.transfer;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.transferapi.application.fraud.FraudDetectionResult;
import project.transferapi.domain.account.AccountValidationService;
import project.transferapi.domain.fraud.FraudDetectionService;
import project.transferapi.domain.transfer.Transfer;
import project.transferapi.domain.transfer.TransferRepository;
import project.transferapi.domain.transfer.TransferValidationService;

import static project.transferapi.application.ErrorStatus.BLOCKED_TRANSFER;

@Component
@Transactional
@RequiredArgsConstructor
public class TransferCreateHandler {
    private final TransferRepository repository;

    private final TransferValidationService validationService;

    private final AccountValidationService accountValidationService;

    private final FraudDetectionService detectionService;

    /**
     * 이체 요청
     * @param command 이체 요청 command
     */
    public void createTransfer(TransferCommand command) {
        // 계좌 검증
        accountValidationService.validAccountInfo(command.fromAccountId(), command.toAccountId());
        // 이체금액 검증
        validationService.validTransferAmount(command.fromAccountId(), command.amount());
        // 이상거래 탐지
        FraudDetectionResult detectionResult = detectionService.detect(command);
        if (detectionResult.blocked()) {
            throw new TransferBadRequestException(BLOCKED_TRANSFER);
        }
        // 이체 저장
        repository.save(Transfer.of(command, detectionResult, repository));
    }
}