package com.codeanapp.project.controller;

import com.codeanapp.project.model.Barang;
import com.codeanapp.project.model.response.DataResponse;
import com.codeanapp.project.service.BarangService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/barang")
public class BarangController {

    private final BarangService barangService;

    public BarangController(BarangService barangService) {
        this.barangService = barangService;
    }

    @PostMapping("/bulk")
    public ResponseEntity<DataResponse<List<Barang>>> bulkInsert(@Valid @RequestBody List<Barang> barangList){
        DataResponse<List<Barang>> data = barangService.bulkInsertBarang(barangList);
        return ResponseEntity.ok().body(data);
    }
}
