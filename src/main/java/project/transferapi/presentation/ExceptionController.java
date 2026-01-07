package project.transferapi.presentation;

import project.transferapi.application.ApplicationException;
import project.transferapi.application.ErrorStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@SuppressWarnings( "all" )
@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
    /**
     * IllegalArgumentException 전용 Handler
     * @param ex IllegalArgumentException
     * @param request WebRequest
     * @return ResponseEntity< Object >
     */
    @ExceptionHandler( IllegalArgumentException.class )
    ResponseEntity< Object > handlerException( IllegalArgumentException ex, WebRequest request ) {
        ErrorResponse errorResponse = new ErrorResponse( "BAD_PARAMETER", ex.getMessage() );

        return handleExceptionInternal( ex, errorResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request );
    }

    /**
     * ApplicationException 전용 Handler
     * @param ex ApplicationException
     * @param request WebRequest
     * @return ResponseEntity< Object >
     */
    @ExceptionHandler( ApplicationException.class )
    ResponseEntity< Object > handlerException( ApplicationException ex, WebRequest request ) {
        ErrorResponse errorResponse = new ErrorResponse( ex.getError(), ex.getErrorMessage() );

        return handleExceptionInternal( ex, errorResponse, new HttpHeaders(), ex.getHttpStatus(), request );
    }

    /**
     * Exception 전용 Handler
     * @param ex Exception
     * @param request WebRequest
     * @return ResponseEntity< Object >
     */
    @ExceptionHandler( Exception.class )
    ResponseEntity< Object > handlerException( Exception ex, WebRequest request ) {
        ErrorResponse errorResponse = new ErrorResponse( ErrorStatus.ERROR );

        return handleExceptionInternal( ex, errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request );
    }
}
