package project.transferapi.presentation.account;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.transferapi.application.account.AccountCreateHandler;
import project.transferapi.application.account.AccountVeiwHandler;
import org.mapstruct.factory.Mappers;
import project.transferapi.application.account.AccountView;
import project.transferapi.application.account.AccountViewDetail;

@RequestMapping("/v1/accounts")
@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountVeiwHandler viewHandler;

    private final AccountCreateHandler createHandler;

    private final AccountModifyHandler modifyHandler;

    private final AccountMapper mapper = Mappers.getMapper(AccountMapper.class);

    /**
     * 계좌 목록 조회
     * @param request 계좌 목록 조회 정보
     * @return AccountViewResponse
     */
    @GetMapping
    AccountViewResponse viewAccounts(AccountViewRequest request) {
        AccountView view = viewHandler.findAccounts(mapper.map(request));

        return mapper.map(view);
    }

    /**
     * 계좌 상제 조회
     * @param id 계좌 ID
     * @return AccountViewDetailResponse
     */
    @GetMapping("/{id}")
    AccountViewDetailResponse viewDetailAccount(@PathVariable Long id) {
        AccountViewDetail viewDetail = viewHandler.findAccount(mapper.map(id));
        return mapper.map(viewDetail);
    }

    /**
     * 계좌 생성
     * @param request 계좌 등록 정보
     */
    @PostMapping
    void createAccount(@RequestBody AccountCreateRequest request) {
        createHandler.createAccount(mapper.map(request));
    }

    /**
     * 계좌 수정
     * @param id 계좌 ID
     * @param request 계좌 수정 정보
     */
    @PatchMapping("/{id}")
    void modifyAccount(@PathVariable Long id,
                       @RequestBody AccountModifyRequest request) {
        modifyHandler.modify(mapper.map(id, request));
    }
}
