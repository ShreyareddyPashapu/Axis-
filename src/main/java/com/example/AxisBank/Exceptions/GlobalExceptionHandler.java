package com.example.AxisBank.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> methodArgNotValidException(MethodArgumentNotValidException exception)
    {
        Map<String , String> errorResponse = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(FieldError -> {
            errorResponse.put(FieldError.getField(), FieldError.getDefaultMessage());
        });
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountHolderNotFoundException.class)
    public ResponseEntity<Map<String, String>> employeeNotFoundException(AccountHolderNotFoundException exception)
    {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}
