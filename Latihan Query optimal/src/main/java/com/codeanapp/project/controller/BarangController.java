package com.codeanapp.project.controller;

import com.codeanapp.project.model.Barang;
import com.codeanapp.project.model.response.DataResponse;
import com.codeanapp.project.model.response.DataTableResponse;
import com.codeanapp.project.service.BarangService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/v1/barang")
public class BarangController {

    private final BarangService barangService;

    public BarangController(BarangService barangService) {
        this.barangService = barangService;
    }

    @Operation(
            summary = "Create alot of barang",
            description = "Create's alot of barang and save it to database"
    )
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataResponse<List<Barang>>> bulkInsert(@Valid @RequestBody List<Barang> barangList){
        DataResponse<List<Barang>> data = barangService.bulkInsertBarang(barangList);
        return ResponseEntity.ok().body(data);
    }

    @GetMapping
    @Operation(
            summary = "Get barang List",
            description = "fetches all barang from database"
    )
    public ResponseEntity<DataTableResponse<Barang>> getAllBarang(
            @RequestParam(defaultValue = "1") @Min(1) int page,
            @RequestParam(defaultValue = "10") @Min(1) int limit,
            @RequestParam(defaultValue = "waktuRekam", required = false) String sortField,
            @RequestParam(defaultValue = "DESC", required = false) String sortOrder
    ) {
        DataTableResponse<Barang> list = barangService.getAllBarang(page, limit, sortField, sortOrder);
        return ResponseEntity.ok().body(list);
    }
}
