package project.transferapi.presentation.transfer;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;
import project.transferapi.application.transfer.TransferCreateHandler;
import project.transferapi.application.transfer.TransferView;
import project.transferapi.application.transfer.TransferViewHandler;
import project.transferapi.domain.Creator;

@RequestMapping("/v1/transfer")
@RestController
@RequiredArgsConstructor
public class TransferController {
    private final TransferViewHandler viewHandler;

    private final TransferCreateHandler createHandler;

    private final TransferMapper mapper = Mappers.getMapper(TransferMapper.class);

    /**
     * 이체 목록 조회
     * @param request 이체 목록 조회 정보
     * @return TransferViewResponse
     */
    @GetMapping
    TransferViewResponse viewTransfer(TransferViewRequest request) {
        TransferView view = viewHandler.viewTransfer(mapper.map(request));

        return mapper.map(view);
    }

    /**
     * 이체 요청
     * @param request 이체 요청 정보
     * @param creator 등록자 정보
     */
    @PostMapping
    void createTransfer(@RequestBody TransferCreateRequest request, Creator creator) {
        createHandler.createTransfer(mapper.map(request, creator));
    }
}
