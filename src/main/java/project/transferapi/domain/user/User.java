package project.transferapi.domain.user;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "TB_USER" )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@Getter
public class User {
    /* 계좌 ID */
    @EmbeddedId
    private UserId id;
    /* 계좌번호 */
    private String name;

    private UserStatus status;
}
