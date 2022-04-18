package dev.dojo.personapi.controller;

import java.util.HashMap;
import java.util.Map;

import dev.dojo.personapi.exceptions.PersonAlreadyRegisteredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import dev.dojo.personapi.dto.response.PersonResponse;
import dev.dojo.personapi.exceptions.PersonNotFoundException;

@ControllerAdvice
public class ExceptionController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<PersonResponse> handlePersonNotFoundException(PersonNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                PersonResponse.builder()
                    .message("Person not found with id: " + ex.getId())
                    .build()
        );
    }

    @ExceptionHandler(PersonAlreadyRegisteredException.class)
    public ResponseEntity<PersonResponse> handlePersonAlreadyRegisteredException(PersonAlreadyRegisteredException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                PersonResponse.builder()
                        .message("Person already registred")
                        .build()
        );
    }

}
