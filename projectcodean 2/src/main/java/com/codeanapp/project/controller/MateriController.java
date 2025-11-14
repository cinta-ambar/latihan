package com.codeanapp.project.controller;

import com.codeanapp.project.dto.MateriUpdateDto;
import com.codeanapp.project.model.Materi;
import com.codeanapp.project.model.response.ApiResponse;
import com.codeanapp.project.model.response.ResponseMessage;
import com.codeanapp.project.service.MateriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/materi")
public class MateriController {

    @Autowired
    private MateriService materiService;

    @PostMapping("/addmateri")
    public ResponseEntity<ApiResponse<Object>> insertMateri(@RequestBody Materi materi){
        materiService.insertMateri(materi);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null));
    }

    @GetMapping("/allmateri")
    public ResponseEntity<ApiResponse<Object>> getAllMateri(@RequestParam int pageNumber,
                                                            @RequestParam int totalItems,
                                                            @RequestParam String sort){
        Map<String, Object> data = materiService.getAllMateri(pageNumber, totalItems, sort);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data));
    }

    @PatchMapping("/updatemateri")
    public ResponseEntity<ApiResponse<Object>> updateMateri(MateriUpdateDto materiUpdateDto){
        materiService.updateMateri(materiUpdateDto);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_MODIFIED.getMessage(), null));
    }

    @DeleteMapping("/deletemateri")
    public ResponseEntity<ApiResponse<Object>> deleteMateri(String idmateri){
        materiService.deleteMateri(idmateri);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null ));
    }
}
