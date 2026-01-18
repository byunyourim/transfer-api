package project.transferapi.domain.fraud.rule;

import project.transferapi.domain.fraud.RuleType;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface FraudDetectionRuleRepository {
    FraudDetectionRuleId nextId();

    Optional<FraudDetectionRule> findById(FraudDetectionRuleId id);

    List<FraudDetectionRule> findByType(RuleType type);

    List<FraudDetectionRule> findAllByEnabledTrue();

    FraudDetectionRule findByTypeAndTermType(RuleType ruleType, TermType termType);

    FraudDetectionRule save(FraudDetectionRule rule);
}