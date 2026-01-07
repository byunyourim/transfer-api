package project.transferapi.application.transfer;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.transferapi.domain.transfer.TransferRepository;

@Component
@RequiredArgsConstructor
@Transactional
public class TransferViewHandler {
    private final TransferRepository repository;

    TransferView viewTransfer(TransferQuery command) {
        return repository.findById(command.id());
    }
}