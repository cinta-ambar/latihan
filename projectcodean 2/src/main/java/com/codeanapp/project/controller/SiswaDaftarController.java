package com.codeanapp.project.controller;

import com.codeanapp.project.model.SiswaDaftar;
import com.codeanapp.project.model.response.ApiResponse;
import com.codeanapp.project.model.response.ResponseMessage;
import com.codeanapp.project.service.SiswaDaftarService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/siswadaftar")
@RestController
public class SiswaDaftarController {

    @Autowired
    private SiswaDaftarService siswaDaftarService;

    @Operation(summary = "l = laki-laki, p = perempuan")
    @PostMapping("/addsiswadaftar")
    public ResponseEntity<ApiResponse<Object>> addSiswaDaftar(SiswaDaftar siswaDaftar){
        siswaDaftarService.addSiswaDaftar(siswaDaftar);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null));
    }

    @GetMapping("/allSiswaDaftar")
    public ResponseEntity<ApiResponse<Object>> getAllSiswaDaftar(@RequestParam int pageNumber,
                                                                 @RequestParam int pageSize,
                                                                 @RequestParam String sort){
        Map<String, Object> data = siswaDaftarService.getAllSiswaDaftar(pageNumber, pageSize, sort);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data));

    }

    @DeleteMapping("/deletesiswadaftar")
    public ResponseEntity<ApiResponse<Object>> deleteSiswaDaftar(String idsiswadaftar){
        siswaDaftarService.deleteSiswaDaftar(idsiswadaftar);
        return ResponseEntity.ok(ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null));
    }


}
