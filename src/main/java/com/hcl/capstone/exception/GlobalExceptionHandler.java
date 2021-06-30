package com.hcl.capstone.exception;

import javax.servlet.http.HttpServletRequest;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

 

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(HttpServletRequest request, Exception ex){
        System.out.println("global based exception handling");
        return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);    
    }

 

}
