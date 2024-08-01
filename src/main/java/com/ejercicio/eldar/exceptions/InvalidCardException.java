package com.ejercicio.eldar.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidCardException extends RuntimeException{

    public InvalidCardException(String mensaje) { super(mensaje); }
}
