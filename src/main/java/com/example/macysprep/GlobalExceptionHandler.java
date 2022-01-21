package com.example.macysprep;

import com.example.macysprep.exceptions.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity handleEmployeeNotFoundException(EmployeeNotFoundException employeeNotFoundException) {
        return new ResponseEntity(employeeNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
