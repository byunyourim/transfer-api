package project.transferapi.application.transfer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project.transferapi.domain.transfer.TransferRepository;

@Component
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TransferViewHandler {
    private final TransferRepository repository;

    /**
     * 이체 목록 조회
     * @param command 이체 목록 조회 command
     * @return TransferView
     */
    public TransferView viewTransfer(TransferQuery command) {
        return repository.findById(command.id());
    }
}