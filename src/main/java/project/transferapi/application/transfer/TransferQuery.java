package project.transferapi.application.transfer;

import project.transferapi.domain.transfer.TransferId;

public record TransferQuery(
        /* 이체 ID */
        TransferId id
) {
}
