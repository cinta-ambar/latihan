package com.latihan.exception;

import com.latihan.model.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NonExistentResourceException.class)
    public ResponseEntity<ApiResponse<String>> handleNotFound(NonExistentResourceException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.fail(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<ApiResponse<String>> handleNotFound(InvalidParameterException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.fail(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(InvalidSortParameterException.class)
    public ResponseEntity<ApiResponse<String>> handleNotFound(InvalidSortParameterException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.fail(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ApiResponse<String>> handleNotFound(ResourceAlreadyExistException e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponse.fail(HttpStatus.CONFLICT, e.getMessage()));
    }
}
