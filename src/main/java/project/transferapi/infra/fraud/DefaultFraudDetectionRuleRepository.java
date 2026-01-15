package project.transferapi.infra.fraud;

import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.transferapi.domain.fraud.RuleType;
import project.transferapi.domain.fraud.rule.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DefaultFraudDetectionRuleRepository implements FraudDetectionRuleRepository {
    private final JPQLQueryFactory queryFactory;

    private final FraudDetectionRuleJPARepository repo;

    private final QFraudDetectionRule rule = QFraudDetectionRule.fraudDetectionRule;

    @Override
    public Optional<FraudDetectionRule> findById(FraudDetectionRuleId id) {
        return repo.findById(id);
    }

    /**
     * 사용 중인 룰 조회
     * @param type 룰 타입
     * @return Optional<FraudDetectionRule>
     */
    @Override
    public List<FraudDetectionRule> findByType(RuleType type) {
        return queryRule().where(rule.type.eq(type)).stream().toList();
    }

    @Override
    public List<FraudDetectionRule> findAllByEnabledTrue() {
        return repo.findAllByEnabledTrue();
    }

    /**
     * 룰 조회
     * @param ruleType 룰 유형
     * @param termType 기간 유형
     * @return FraudDetectionRule
     */
    @Override
    public FraudDetectionRule findByTypeAndTermType(RuleType ruleType, TermType termType) {
        return Optional.ofNullable(queryRule().where(rule.type.eq(ruleType))
                                              .where(rule.termType.eq(termType)));
    }

    @Override
    public FraudDetectionRule save(FraudDetectionRule rule) {
        return repo.save(rule);
    }

    @Override
    public FraudDetectionRuleId nextId() {
        return FraudDetectionRuleId.of(Long.valueOf(UUID.randomUUID().toString()));
    }

    /**
     * 사용 중인 룰 조회
     * @return JPQLQuery<FraudDetectionRule>
     */
    private JPQLQuery<FraudDetectionRule> queryRule() {
        return queryFactory.selectFrom(rule)
                           .where(rule.enabled.eq(true));
    }
}
