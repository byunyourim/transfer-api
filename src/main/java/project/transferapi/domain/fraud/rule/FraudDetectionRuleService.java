package project.transferapi.domain.fraud.rule;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudDetectionRuleService {
    private final FraudDetectionRuleRepository repo;
}
