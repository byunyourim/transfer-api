package project.transferapi.application.transfer;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.transferapi.domain.account.AccountValidationService;
import project.transferapi.domain.transfer.Transfer;
import project.transferapi.domain.transfer.TransferRepository;
import project.transferapi.domain.transfer.TransferValidationService;

@Component
@Transactional
@RequiredArgsConstructor
public class TransferCreateHandler {
    private final TransferRepository repo;

    private final TransferValidationService validationService;

    private final AccountValidationService accountValidationService;
    /**
     * 이체 요청
     * @param command 이체 요청 command
     */
    public void createTransfer(TransferCommand command) {
        // 계좌 검증
        accountValidationService.validAccountInfo(command.fromAccountId());
        // 이체 금액 검증
        validationService.validTransferAmount(command.fromAccountId(), command.amount());

        Transfer transfer = Transfer.of(command, repo);
    }
}