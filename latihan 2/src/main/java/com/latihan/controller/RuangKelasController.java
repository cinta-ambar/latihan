package com.latihan.controller;

import com.latihan.exception.ResourceAlreadyExistException;
import com.latihan.model.entities.RuangKelas;
import com.latihan.model.responses.ApiResponse;
import com.latihan.model.responses.ResponseMessage;
import com.latihan.services.implemens.RuangKelasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/ruangKelasApp/v4/")
public class RuangKelasController {
    @Autowired
    RuangKelasServiceImpl ruangKelasService;

    @PostMapping("ruangKelasAdd")
    public ApiResponse<Object> addRuangKelas(@RequestBody RuangKelas ruangKelasAdd) throws ResourceAlreadyExistException {
        ruangKelasService.addRuangKelas(ruangKelasAdd);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null);
    }

    @GetMapping("ruangKelasGet")
    public ApiResponse<Object> getRuangKelas(@RequestParam int pageNumber,
                                             @RequestParam int pageSize,
                                             @RequestParam String sort){
        Map<String, Object> data = ruangKelasService.getRuangKelas(pageNumber, pageSize,sort);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data);
    }

    @GetMapping("ruangKelasGet/{idRuangKelas}")
    public ApiResponse<Object> getRuangKelasById(@PathVariable UUID idRuangKelas){
        Optional<RuangKelas> data = ruangKelasService.getRuangKelasById(idRuangKelas);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data);
    }

    @PutMapping("ruangKelasEdit")
    public ApiResponse<Object> editRuangKelasById(@RequestBody RuangKelas ruangKelas){
        ruangKelasService.editRuangKelasById(ruangKelas);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_MODIFIED.getMessage(), null);
    }

    @DeleteMapping("ruangKelasDelete/{idRuangKelas}")
    public ApiResponse<Object> deleteRuangKelasById(@PathVariable UUID idRuangKelas){
        ruangKelasService.deleteRuangKelasById(idRuangKelas);
        return ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null);
    }
}
