package com.codeanapp.project.controller;

import com.codeanapp.project.model.PelajarTask;
import com.codeanapp.project.model.response.ApiResponse;
import com.codeanapp.project.model.response.ResponseMessage;
import com.codeanapp.project.service.PelajarTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/pelajartask")
public class PelajarTaskController {

    @Autowired
    private PelajarTaskService pelajarTakService;

    @PostMapping("/addpelajar")
    public ResponseEntity<ApiResponse<Object>> insertPelajarTask(@RequestBody PelajarTask pelajarTask){
        pelajarTakService.insertPelajarTask(pelajarTask);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null));
    }

    @GetMapping("/allpelajarTask")
    public ResponseEntity<ApiResponse<Object>> getAllPelajarTask(@RequestParam int pageNumber,
                                                                 @RequestParam int totalItems,
                                                                 @RequestParam String sort){
        Map<String, Object> data = pelajarTakService.getAllPelajarTask(pageNumber, totalItems, sort);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data));
    }

    @DeleteMapping("/deletepelajartask")
    public ResponseEntity<ApiResponse<Object>> deletePelajarTask(String idpelajartask){
        pelajarTakService.deletePelajarTask(idpelajartask);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null));
    }
}
