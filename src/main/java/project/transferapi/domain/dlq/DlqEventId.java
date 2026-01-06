package project.transferapi.domain.dlq;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PRIVATE )
public @Getter class DlqEventId implements Serializable {
    @Serial
    private static final long serialVersionUID = 4559539098383372659L;

    /* DLQ ID */
    @Column( name = "DLQ_EVNET_ID" )
    private Long id;

    @Override
    public String toString() {
        return "" + id;
    }

    /**
     * DLQ ID 생성
     * @param id DLQ ID
     * @return DlqEventId
     */
    public static DlqEventId of(Long id ) {
        return ( id == null || id < 0L ) ? null : new DlqEventId( id );
    }
}
