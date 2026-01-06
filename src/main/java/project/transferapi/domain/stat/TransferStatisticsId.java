package project.transferapi.domain.stat;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PRIVATE )
public @Getter class TransferStatisticsId implements Serializable {
    @Serial
    private static final long serialVersionUID = 4559539098383372659L;

    /* 이체집계 ID */
    @Column( name = "TRANSFER_STATISTICS_ID" )
    private Long id;

    @Override
    public String toString() {
        return "" + id;
    }

    /**
     * 이체집계 ID 생성
     * @param id 이체집계 ID
     * @return TransferStatisticsId
     */
    public static TransferStatisticsId of(Long id ) {
        return ( id == null || id < 0L ) ? null : new TransferStatisticsId( id );
    }
}
