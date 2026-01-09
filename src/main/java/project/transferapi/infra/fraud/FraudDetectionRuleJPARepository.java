package project.transferapi.infra.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import project.transferapi.domain.fraud.rule.FraudDetectionRule;
import project.transferapi.domain.fraud.rule.FraudDetectionRuleId;

import java.util.List;

public interface FraudDetectionRuleJPARepository
    extends JpaRepository<FraudDetectionRule, FraudDetectionRuleId> {

    /**
     * 활성화된 룰 조회
     */
    List<FraudDetectionRule> findAllByEnabledTrue();
}
