package project.transferapi.presentation.transfer;

import project.transferapi.application.transfer.TransferCommand;
import project.transferapi.application.transfer.TransferQuery;
import project.transferapi.application.transfer.TransferView;
import project.transferapi.domain.Creator;

public interface TransferMapper {
    TransferQuery map(TransferViewRequest request);

    TransferViewResponse map(TransferView view);

    TransferCommand map(TransferCreateRequest request, Creator creator);
}
