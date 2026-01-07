package project.transferapi.application;

import lombok.Getter;

public @Getter enum ErrorStatus {
    ERROR( "에러가 발생하였습니다." ),
    ACCOUNT_NOT_FOUND( "계좌 정보를 찾을 수 없습니다." ),
    PER_TRANSFER_LIMIT_INVALID( "1회 이체한도가 잘못되었습니다." ),
    PER_TRANSFER_LIMIT_EXCEED( "1회 이체한도가 기준치를 초과하였습니다." ),
    DAILY_TRANSFER_LIMIT_INVALID( "하루 이체한도가 잘못되었습니다." ),
    DAILY_TRANSFER_LIMIT_EXCEED( "하루 이체한도가 기준치를 초과하였스니다." ),
    OWNER_NOT_FOUND( "소유자 정보를 찾을 수 없습니다." );

    private final String message;

    ErrorStatus(String message ) {
        this.message = message;
    }
}
