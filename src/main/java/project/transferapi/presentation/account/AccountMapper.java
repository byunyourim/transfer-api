package project.transferapi.presentation.account;

import org.mapstruct.Mapper;
import project.transferapi.application.account.*;
import project.transferapi.domain.Creator;
import project.transferapi.domain.Modifier;
import project.transferapi.presentation.VOMapper;

@Mapper
public interface AccountMapper extends VOMapper {
    AccountQuery map(AccountViewRequest request);

    AccountViewResponse map(AccountView accountView);

    AccountQuery map(Long id);

    AccountViewDetailResponse map(AccountViewDetail viewDetail);

    AccountCreateCommand map(AccountCreateRequest request, Creator creator);

    AccountModifyCommand map(Long id, AccountModifyRequest request, Modifier modifier);
}
