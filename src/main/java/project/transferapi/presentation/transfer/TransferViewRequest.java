package project.transferapi.presentation.transfer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter @Setter
public class TransferViewRequest {
    /* 회원 ID */
    Long userId;
    /* 시작일자 */
    Long start;
    /* 종료일자 */
    Long end;
}
