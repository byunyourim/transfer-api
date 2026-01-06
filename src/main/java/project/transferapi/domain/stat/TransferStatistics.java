package project.transferapi.domain.stat;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "TB_TRANSFER_STATISTICS" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class TransferStatistics {
    /* 이체집계 ID */
    @EmbeddedId
    private TransferStatisticsId id;
    /* 계정 ID */
    private Long accountId;
}
