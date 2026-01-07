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
public class Creator implements Serializable {
    @Serial
    private static final long serialVersionUID = -6697834426181678273L;
    /* 등록자 ID */
    @Embedded
    @AttributeOverride( name = "id", column = @Column(name = "REG_ID") )
    private UserId id;
    /* 등록일자 */
    @Column( name = "REG_DT" )
    private LocalDateTime dateTime;

    /**
     * 등록자 생성
     * @param id 등록자 ID
     * @return Creator
     */
    public static Creator of (UserId id) {
        return new Creator(id, LocalDateTime.now());
    }

    /**
     * 등록자 생성
     * @param id 등록자 ID
     * @param dateTime 등록시간
     * @return Creator
     */
    public static Creator of (UserId id, LocalDateTime dateTime) {
        return new Creator(id, dateTime);
    }
}