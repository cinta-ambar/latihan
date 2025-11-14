package com.codeanapp.project.controller;

import com.codeanapp.project.model.Presensi;
import com.codeanapp.project.model.response.ApiResponse;
import com.codeanapp.project.model.response.ResponseMessage;
import com.codeanapp.project.service.PresensiService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/v1/presensi")
public class PresensiController {

    @Autowired
    private PresensiService presensiService;

    @Operation(summary = "id tidak perlu diisi")
    @PostMapping("/addpresensi")
    public ResponseEntity<ApiResponse<Object>> insertPresensi(@RequestBody Presensi presensi){
        presensiService.insertPresensi(presensi);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null));
    }

    @Operation(summary = "get all presensi")
    @GetMapping("/getPresensi")
    public ResponseEntity<ApiResponse<Object>> getAllPeran(){
        List<Presensi> data = presensiService.getAllPresensi();
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data));
    }

    @DeleteMapping("/{idpresensi}")
    public ResponseEntity<ApiResponse<Object>> deletePresensi(String idpresensi){
        presensiService.deletePresensi(idpresensi);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null));
    }

}
