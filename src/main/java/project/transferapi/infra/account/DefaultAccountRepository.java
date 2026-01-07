package project.transferapi.infra.account;

import com.querydsl.core.ResultTransformer;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.transferapi.application.DateUtil;
import project.transferapi.application.account.AccountQuery;
import project.transferapi.application.account.AccountView;
import project.transferapi.application.account.AccountViewDetail;
import project.transferapi.domain.account.Account;
import project.transferapi.domain.account.AccountId;
import project.transferapi.domain.account.AccountRepository;
import project.transferapi.domain.account.QAccount;

import java.util.List;
import java.util.Optional;

import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.types.Projections.constructor;

@Repository
@RequiredArgsConstructor
public class DefaultAccountRepository implements AccountRepository {
    private final JPQLQueryFactory queryFactory;

    private final AccountJPARepository repo;

    private final QAccount account = QAccount.account;
    /**
     * 결제 ID 조회
     * @return AccountId
     */
    @Override
    public AccountId nextId() {
        return AccountId.of( repo.nextId(DateUtil.nowSequenceDateTimeString()) );
    }

    /**
     * 계좌 목록 조회
     * @param query 계좌 목록 조회 정보
     * @return AccountView
     */
    @Override
    public AccountView findAccountView(AccountQuery query) {
        JPQLQuery<Account> listQuery = queryAccount();

        if (query.userId() != null) {
            listQuery.where(account.userId.eq(query.userId()));
        }
        if (query.status() != null) {
            listQuery.where(account.status.eq(query.status()));
        }
        long total = listQuery.select(account.countDistinct()).fetchOne();

        List<AccountView.Account> accounts = listQuery.transform(accountProjection());

        return new AccountView(total, accounts);

    }

    /**
     * 계좌 상세 조회
     * @param accountId 계좌 ID
     * @return AccountViewDetail
     */
    @Override
    public AccountViewDetail findAccountDetailById(AccountId accountId) {
        return queryFactory.select(accountViewDetailProjection())
                           .from(account)
                           .where(account.id.eq(accountId))
                           .fetchOne();
    }

    /**
     * 계좌 정보 조회
     * @param id 계좌 ID
     * @return Optional<Account>
     */
    @Override
    public Optional<Account> findAccountById(AccountId id) {
        return Optional.empty();
    }

    /**
     * 계좌 개수 조회
     * @param accountNumber 계좌번호
     * @return long
     */
    @Override
    public long accountByAccountNumber(Long accountNumber) {
        return 1L;
    }

    /**
     * 계좌 갯수 조회
     * @param id 계좌 ID
     * @return long
     */
    @Override
    public long accountById(AccountId id) {
        return 1L;
    }

    /**
     * 계좌 조회 쿼리
     * @return JPQLQuery<Account>
     */
    private JPQLQuery<Account> queryAccount() {
        return queryFactory.selectFrom(account);
    }

    /**
     * 계좌 목록 조회 Projection
     * @return ResultTransformer<List<AccountView.Account>>
     */
    private ResultTransformer<List<AccountView.Account>> accountProjection() {
        ConstructorExpression<AccountView.Account> accountExpression =
                constructor(AccountView.Account.class, account.id, account.accountNumber, account.status);

        return groupBy(account.id).list(accountExpression);
    }

    /**
     * 게좌 상세 조회 Projection
     * ConstructorExpression<AccountViewDetail>
     */
    private ConstructorExpression<AccountViewDetail> accountViewDetailProjection() {
        return Projections.constructor(AccountViewDetail.class, account.id, account.accountNumber, account.userId,
                                       account.balance, account.status, account.createdAt, account.perTransferLimit);
    }
}
