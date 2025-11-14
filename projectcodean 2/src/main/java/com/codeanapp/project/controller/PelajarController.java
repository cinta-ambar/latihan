package com.codeanapp.project.controller;

import com.codeanapp.project.dto.PelajarUpdateDto;
import com.codeanapp.project.model.Pelajar;
import com.codeanapp.project.model.response.ApiResponse;
import com.codeanapp.project.model.response.ResponseMessage;
import com.codeanapp.project.service.PelajarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/pelajar")
public class PelajarController {

    @Autowired
    private PelajarService pelajarService;

    @PostMapping("/addpelajar")
    public ResponseEntity<ApiResponse<Object>> insertPelajar(Pelajar pelajar){
        pelajarService.insertPelajar(pelajar);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null));
    }

    @GetMapping("/allpelajar")
    public ResponseEntity<ApiResponse<Object>> getAllPelajar(@RequestParam int pageNumber,
                                                             @RequestParam int totalItems,
                                                             @RequestParam String sort){

        Map<String, Object> data = pelajarService.getAllPelajar(pageNumber, totalItems, sort);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data));
    }

    @PatchMapping("/updatepelajar")
    public ResponseEntity<ApiResponse<Object>> updatePelajar(PelajarUpdateDto pelajarUpdateDto){
        pelajarService.updatePelajar(pelajarUpdateDto);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_MODIFIED.getMessage(), null));
    }

    @DeleteMapping("/deletepelajar")
    public ResponseEntity<ApiResponse<Object>> deletePelajar(String idpelajar){
        pelajarService.deletePelajar(idpelajar);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null));
    }

}
