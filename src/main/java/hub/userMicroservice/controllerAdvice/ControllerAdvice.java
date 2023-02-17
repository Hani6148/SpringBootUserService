package hub.userMicroservice.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import hub.userMicroservice.CustomExceptions.UserCreationException;

@RestControllerAdvice
public class ControllerAdvice {

	 @ExceptionHandler(UserCreationException.class)
	    public ResponseEntity<String> handleCreateUserException(UserCreationException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	
}
