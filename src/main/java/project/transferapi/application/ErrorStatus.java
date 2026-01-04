package project.transferapi.application;

import lombok.Getter;

public @Getter enum ErrorStatus {
    ERROR( "에러가 발생하였습니다." ),
    ACCOUNT_NOT_FOUND( "계좌 정보를 찾을 수 없습니다." ),
    INVALID_ACCOUNT_BALANCE( "계좌생성시 잔액은 0보다 커야합니다." ),
    PER_TRANSFER_LIMIT_INVALID( "1회 이체한도는 0 이상 50,000,000 미만으로 설정할 수 있습니다." ),
    DAILY_TRANSFER_LIMIT_INVALID( "하루 이체한도는 0 이상 50,000,000 미만으로 설정할 수 있습니다." ),
    CANNOT_CHANGE_ACCOUNT_INFO( "%s 상태에서는 계좌 정보를 변경할 수 없습니다." ),
    USER_NOT_FOUND( "회원 정보를 찾을 수 없습니다." );

    private final String message;

    ErrorStatus(String message ) {
        this.message = message;
    }
}
