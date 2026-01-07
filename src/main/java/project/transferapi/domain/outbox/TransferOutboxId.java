package project.transferapi.domain.outbox;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PRIVATE )
public @Getter class TransferOutboxId implements Serializable {
    @Serial
    private static final long serialVersionUID = 4559539098383372659L;

    /* outbox event ID */
    @Column( name = "TRANSFER_OUTBOX_ID" )
    private Long id;

    @Override
    public String toString() {
        return "" + id;
    }

    /**
     * outbox event ID 생성
     * @param id outbox event ID
     * @return TransferOutboxEventId
     */
    public static TransferOutboxId of(Long id ) {
        return ( id == null || id < 0L ) ? null : new TransferOutboxId( id );
    }
}
