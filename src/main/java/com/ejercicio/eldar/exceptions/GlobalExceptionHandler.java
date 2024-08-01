package com.ejercicio.eldar.exceptions;

import com.ejercicio.eldar.responses.OperacionInvalidaResponse;
import com.ejercicio.eldar.responses.TarjetaInvalidaResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException excepcion) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : excepcion.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        errors.put("error", "true");

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity<OperacionInvalidaResponse> handlerResourceNotFoundException(InvalidOperationException excepcion) {
        OperacionInvalidaResponse operacionException = new OperacionInvalidaResponse(excepcion.getMessage(), true);
        return new ResponseEntity<>(operacionException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCardException.class)
    public ResponseEntity<TarjetaInvalidaResponse> handlerResourceNotFoundException(InvalidCardException excepcion) {
        TarjetaInvalidaResponse tarjetaException = new TarjetaInvalidaResponse(excepcion.getMessage(), true);
        return new ResponseEntity<>(tarjetaException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleMissingPathVariable(ConstraintViolationException excepcion){
        return new ResponseEntity<>("Path variable is missing: " + excepcion.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
