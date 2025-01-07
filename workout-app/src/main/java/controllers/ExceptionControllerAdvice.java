package controllers;

import exceptions.InvalidPasswordException;
import exceptions.LoginDoesNotExistException;
import exceptions.UserAlreadyExistsException;
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

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> exceptionUserAlreadyExistsHandler(){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorMessage("User already exists");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ErrorDetails> exceptionInvalidPasswordException(){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorMessage("Invalid password");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
