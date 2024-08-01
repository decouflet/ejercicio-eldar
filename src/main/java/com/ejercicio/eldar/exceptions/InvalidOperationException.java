package com.ejercicio.eldar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidOperationException extends RuntimeException{
    public InvalidOperationException(String mensaje) { super(mensaje); }
}
