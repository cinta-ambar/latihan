package com.codeanapp.project.controller;

import com.codeanapp.project.model.PelajarExamp;
import com.codeanapp.project.model.PelajarMateri;
import com.codeanapp.project.model.response.ApiResponse;
import com.codeanapp.project.model.response.ResponseMessage;
import com.codeanapp.project.service.PelajarExampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/pelajarexamp")
public class PelajarExampController {

    @Autowired
    private PelajarExampService pelajarExampService;

    @PostMapping("/addpelajarexamp")
    public ResponseEntity<ApiResponse<Object>> insertPelajarExamp(PelajarExamp pelajarExamp){
        pelajarExampService.insertPelajarExamp(pelajarExamp);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null));
    }

    @GetMapping("/allpelajarExamp")
    public ResponseEntity<ApiResponse<Object>> getAllPelajarExamp(@RequestParam int pageNumber,
                                                                   @RequestParam int totalItems,
                                                                   @RequestParam String sort){
        Map<String, Object> data = pelajarExampService.getAllPelajarExamp(pageNumber, totalItems, sort);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data));
    }

    @DeleteMapping("/deletepelajarexamp")
    public ResponseEntity<ApiResponse<Object>> deletePelajarExamp(String idpelajarexamp){
        pelajarExampService.deletePelajarExamp(idpelajarexamp);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null));
    }
}
