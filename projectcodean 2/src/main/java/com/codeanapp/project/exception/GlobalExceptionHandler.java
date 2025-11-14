package com.codeanapp.project.exception;

import com.codeanapp.project.model.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NonExistentResourceException.class)
    public ResponseEntity<ApiResponse<String>> hendleNotFound(NonExistentResourceException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.fail(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<ApiResponse<String>> hendleNotFound(InvalidParameterException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.fail(HttpStatus.NOT_FOUND, e.getMessage()));
    }
}
