package project.transferapi.domain.fraud.rule;

import java.util.List;
import java.util.Optional;

public interface FraudDetectionRuleRepository {
    Optional<FraudDetectionRule> findById(FraudDetectionRuleId id);

    List<FraudDetectionRule> findAllByEnabledTrue();

    FraudDetectionRule save(FraudDetectionRule rule);

    FraudDetectionRuleId nextId();
}