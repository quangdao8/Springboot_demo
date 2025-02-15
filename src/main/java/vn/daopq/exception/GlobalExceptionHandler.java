package vn.daopq.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus (HttpStatus.BAD_REQUEST)
   public ErrorResponse handleValidationException(Exception e, WebRequest request) {
       ErrorResponse errorResponse = new ErrorResponse();
       errorResponse.setTimestamp(new Date());
       errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
       errorResponse.setMessage(e.getMessage());
       errorResponse.setError(e.getClass().getSimpleName());
       errorResponse.setPath(request.getDescription(false)) ;


       return errorResponse;
   }
}
