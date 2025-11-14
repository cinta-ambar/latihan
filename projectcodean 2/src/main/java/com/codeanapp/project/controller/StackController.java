package com.codeanapp.project.controller;

import com.codeanapp.project.model.Stack;
import com.codeanapp.project.model.response.ApiResponse;
import com.codeanapp.project.model.response.ResponseMessage;
import com.codeanapp.project.service.StackService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/stack")
public class StackController {

    @Autowired
    private StackService stackService;

    @Operation(summary = "a = frontend, b = backend")
    @PostMapping("/addstack")
    public ResponseEntity<ApiResponse<Object>> addStack(@RequestBody Stack stack){
        stackService.insertStack(stack);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null));
    }

    @GetMapping("/allstack")
    public ResponseEntity<ApiResponse<Object>> getAllStack(){
        List<Stack> data = stackService.getAllStack();
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data));
    }

    @DeleteMapping("/deletestack")
    public ResponseEntity<ApiResponse<Object>> deleteStack(String idstack){
        stackService.deleteStack(idstack);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null));
    }

}
