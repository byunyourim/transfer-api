package project.transferapi.domain.fraud.rule;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PRIVATE )
public @Getter class FraudDetectionRuleId implements Serializable {
    @Serial
    private static final long serialVersionUID = 4559539098383372659L;

    /* 룰 ID */
    @Column( name = "FRAUD_DETECTION_RULE_ID" )
    private Long id;

    @Override
    public String toString() {
        return "" + id;
    }

    /**
     * 룰 ID 생성
     * @param id 룰 ID
     * @return FraudDetectionRuleId
     */
    public static FraudDetectionRuleId of(Long id ) {
        return ( id == null || id < 0L ) ? null : new FraudDetectionRuleId( id );
    }
}
