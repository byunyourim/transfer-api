package project.transferapi.presentation.transfer;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.transferapi.application.transfer.TransferCreateHandler;
import project.transferapi.application.transfer.TransferViewHandler;

@RequestMapping("/v1/transfer")
@RestController
@RequiredArgsConstructor
public class TransferController {
    private final TransferViewHandler viewHandler;

    private final TransferCreateHandler createHandler;

    private final TransferMapper mapper = Mappers.getMapper(TransferMapper.class);

}
