package project.transferapi.domain.transfer;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PRIVATE )
public @Getter class TransferId implements Serializable {
    @Serial
    private static final long serialVersionUID = 4559539098383372659L;

    /* 이체 ID */
    @Column( name = "TRANSFER_ID" )
    private Long id;

    @Override
    public String toString() {
        return "" + id;
    }

    /**
     * 회원 ID 생성
     * @param id 회원 ID
     * @return UserId
     */
    public static TransferId of(Long id ) {
        return ( id == null || id < 0L ) ? null : new TransferId( id );
    }
}
