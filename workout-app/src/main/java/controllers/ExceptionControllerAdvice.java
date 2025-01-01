package controllers;

import exceptions.LoginDoesNotExistException;
import model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(LoginDoesNotExistException.class)
    public ResponseEntity<ErrorDetails> exceptionLoginDoesNotExistHandler(){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorMessage("Login does not exist. Sign up");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
