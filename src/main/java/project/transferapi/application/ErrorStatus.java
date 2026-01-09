package project.transferapi.application;

import lombok.Getter;

public @Getter enum ErrorStatus {
    ERROR( "에러가 발생하였습니다." ),
    ACCOUNT_NOT_FOUND( "계좌 정보를 찾을 수 없습니다." ),
    PER_TRANSFER_LIMIT_EXCEED( "1회 이체한도가 기준치를 초과하였습니다." ),
    DAILY_TRANSFER_LIMIT_EXCEED( "하루 이체한도가 기준치를 초과하였습니다." ),
    TRANSFER_AMOUNT_INVALID( "이체할 금액이 올바르지 않습니다." ),
    BLOCKED_TRANSFER( "이체가 차단되었습니다. 위험도: %s " ),
    USER_NOT_FOUND( "소유자 정보를 찾을 수 없습니다." );

    private final String message;

    ErrorStatus(String message ) {
        this.message = message;
    }
}