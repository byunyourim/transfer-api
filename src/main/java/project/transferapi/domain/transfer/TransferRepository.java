package project.transferapi.domain.transfer;

import org.springframework.stereotype.Repository;
import project.transferapi.application.transfer.TransferView;

@Repository
public interface TransferRepository {
    TransferView findById(TransferId id);
}
