package com.codeanapp.project.controller;

import com.codeanapp.project.exception.InvalidFormatException;
import com.codeanapp.project.model.Pengajar;
import com.codeanapp.project.model.response.ApiResponse;
import com.codeanapp.project.model.response.ResponseMessage;
import com.codeanapp.project.service.PengajarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/pengajar")
public class PengajarController {

    @Autowired
    private PengajarService pengajarService;

    @PostMapping("/addpengajar")
    public ResponseEntity<ApiResponse<Object>> insertPengajar (@RequestBody Pengajar pengajar){
        try {
            pengajarService.insertPengajar(pengajar);
            return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null));
        }catch (InvalidFormatException e){
            return ResponseEntity.ok(ApiResponse.fail(HttpStatus.BAD_REQUEST, ResponseMessage.DATA_INVALID.getMessage(), e.getMessage()));
        }
    }

    @GetMapping("/allpengajar")
    public ResponseEntity<ApiResponse<Object>> getAllSiswaDetail(){
        List<Pengajar> data = pengajarService.getAllPengajar();
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data));
    }

    @DeleteMapping("/deletepengajar")
    public ResponseEntity<ApiResponse<Object>> deletePengajar(String idpengajar){
        pengajarService.deletePengajar(idpengajar);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null));
    }

}
