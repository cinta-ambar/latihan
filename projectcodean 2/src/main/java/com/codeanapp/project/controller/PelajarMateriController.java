package com.codeanapp.project.controller;


import com.codeanapp.project.model.PelajarMateri;
import com.codeanapp.project.model.response.ApiResponse;
import com.codeanapp.project.model.response.ResponseMessage;
import com.codeanapp.project.service.PelajarMateriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/pelajarmateri")
public class PelajarMateriController {

    @Autowired
    private PelajarMateriService pelajarMateriService;

    @PostMapping("/addpelajarmateri")
    public ResponseEntity<ApiResponse<Object>> insertPelajarMateri(PelajarMateri pelajarMateri){
        pelajarMateriService.insertPelajarMateri(pelajarMateri);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null));
    }

    @GetMapping("/allpelajarMateri")
    public ResponseEntity<ApiResponse<Object>> getAllPelajarMateri(@RequestParam int pageNumber,
                                                                 @RequestParam int totalItems,
                                                                 @RequestParam String sort){
        Map<String, Object> data = pelajarMateriService.getAllPelajarMateri(pageNumber, totalItems, sort);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data));
    }

    @DeleteMapping("/deletepelajarmateri")
    public ResponseEntity<ApiResponse<Object>> deletePelajarMateri(String idpelajarmateri){
        pelajarMateriService.deletePelajarMateri(idpelajarmateri);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null));
    }
}
