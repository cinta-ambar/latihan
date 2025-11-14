package com.codeanapp.project.controller;

import com.codeanapp.project.dto.ExampUpdateDto;
import com.codeanapp.project.model.Examp;
import com.codeanapp.project.model.response.ApiResponse;
import com.codeanapp.project.model.response.ResponseMessage;
import com.codeanapp.project.service.ExampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/examp")
public class ExampController {

    @Autowired
    private ExampService exampService;


    @PostMapping("/addexamp")
    public ResponseEntity<ApiResponse<Object>> insertExamp(@RequestBody Examp examp){
        exampService.insertExamp(examp);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null));
    }

    @GetMapping("/allexamp")
    public ResponseEntity<ApiResponse<Object>> getAllExamp(){
        List<Examp> data = exampService.getAllExamp();
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), data));
    }

    @PatchMapping("/updateExamp")
    public ResponseEntity<ApiResponse<Object>> updateExamp(ExampUpdateDto exampUpdateDto){
        exampService.updateExamp(exampUpdateDto);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_MODIFIED.getMessage(), null));
    }

    @DeleteMapping("/deleteExamp")
    public ResponseEntity<ApiResponse<Object>> deleteExamp(String idexamp){
        exampService.deleteExamp(idexamp);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null));
    }
}
