package project.transferapi.presentation;

import project.transferapi.application.ErrorStatus;

public record ErrorResponse(
        /* 에러코드 */
        String error,
        /* 에러 메시지 */
        String message,
        /* 응답 데이터 */
        Object body
) {
    public ErrorResponse( ErrorStatus error ) {
        this( error.name(), error.getMessage(), null );
    }

    public ErrorResponse( String error, String message ) {
        this( error, message, null );
    }

    public ErrorResponse( ErrorStatus error, String errorMessage) {
        this( error.name(), errorMessage, null );
    }

    public ErrorResponse( Object error, String message, Object data ) {
        this( error.toString(), message, data );
    }
}
