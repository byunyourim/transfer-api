package project.transferapi.domain.account;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PRIVATE )
public @Getter class AccountId implements Serializable {
    @Serial
    private static final long serialVersionUID = 4559539098383372659L;

    /* 계좌 ID */
    @Column( name = "ACCOUNT_ID" )
    private Long id;

    @Override
    public String toString() {
        return "" + id;
    }

    /**
     * 계좌 ID 생성
     * @param id 계좌 ID
     * @return AccountId
     */
    public static AccountId of( Long id ) {
        return ( id == null || id < 0L ) ? null : new AccountId( id );
    }
}
