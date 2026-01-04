package project.transferapi.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import project.transferapi.domain.user.UserId;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Access(AccessType.FIELD)
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PRIVATE )
public class Modifier implements Serializable {
    @Serial
    private static final long serialVersionUID = -6697834426181678273L;
    /* 수정자 ID */
    @Embedded
    @AttributeOverride( name = "id", column = @Column(name = "MOD_ID") )
    private UserId id;
    /* 수정일자 */
    @Column( name = "MOD_DT" )
    private LocalDateTime dateTime;

    /**
     * 수정자 생성
     * @param id 수정자 ID
     * @return Modifier
     */
    public static Modifier of (UserId id ) {
        return new Modifier(id, LocalDateTime.now());
    }

    /**
     * 수정자 생성
     * @param id 수정자 ID
     * @param dateTime 수정 시간
     * @return Modifier
     */
    public static Modifier of (UserId id, LocalDateTime dateTime) {
        return new Modifier(id, dateTime);
    }
}