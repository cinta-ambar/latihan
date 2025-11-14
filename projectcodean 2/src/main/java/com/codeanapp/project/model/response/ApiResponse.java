package com.codeanapp.project.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private int statusCode;
    private String status;
    private String message;
    private T data;
    private T errors;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getErrors() {
        return errors;
    }

    public void setErrors(T errors) {
        this.errors = errors;
    }

    public static <T> ApiResponse<T> succes(HttpStatus httpStatus, String message, T data){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setStatusCode(httpStatus.value());
        apiResponse.setStatus(httpStatus.getReasonPhrase());
        apiResponse.setMessage(message);
        apiResponse.setData(data);
        return apiResponse;
    }
    public static <T> ApiResponse<T> fail(HttpStatus httpStatus, String message, T errors){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setStatusCode(httpStatus.value());
        apiResponse.setStatus(httpStatus.getReasonPhrase());
        apiResponse.setMessage(message);
        apiResponse.setErrors(errors);
        return apiResponse;
    }

    public static <T> ApiResponse<T> fail(HttpStatus httpStatus, String message){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setStatusCode(httpStatus.value());
        apiResponse.setStatus(httpStatus.getReasonPhrase());
        apiResponse.setMessage(message);
        return apiResponse;
    }
}
