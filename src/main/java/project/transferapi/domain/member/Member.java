package project.transferapi.domain.member;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table( name = "TB_MEMBER" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class Member {
    /* 관리자 ID */
    @EmbeddedId
    private MemberId id;
    /* 운영자 유형 */
    private MemberType type;
    /* 생성일자 */
    private LocalDateTime created_at;
    /* 수정일자 */
    private LocalDateTime modified_at;
}
