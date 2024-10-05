package com.klinnovations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler { 
    
    @ExceptionHandler(EmployeeNotFoundException.class) 
    @ResponseStatus(HttpStatus.NOT_FOUND) 
    public ResponseEntity<String> handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException){ 
        return new ResponseEntity<>(employeeNotFoundException.getMessage(), HttpStatus.NOT_FOUND); 
    } 
    
    @ExceptionHandler(EmployeeAlreadyExistsException.class) 
    @ResponseStatus(HttpStatus.CONFLICT) 
    public ResponseEntity<String> handleEmployeeAlreadyExistsException(EmployeeAlreadyExistsException employeeAlreadyExistsException){ 
        return new ResponseEntity<>(employeeAlreadyExistsException.getMessage(),HttpStatus.CONFLICT); 
    } 
    
}
