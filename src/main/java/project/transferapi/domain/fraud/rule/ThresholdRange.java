package project.transferapi.domain.fraud.rule;

import jakarta.persistence.Embeddable;
import lombok.*;

@Builder( access = AccessLevel.PROTECTED )
@Embeddable
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PRIVATE )
public @Getter class ThresholdRange {
    /* 최소 */
    private Long min;
    /* 최대 */
    private Long max;
}
