package com.latihan.controller;

import com.latihan.dtos.kursus.KursusPostDto;
import com.latihan.dtos.kursus.KursusResponseDto;
import com.latihan.model.entities.Kursus;
import com.latihan.model.responses.ApiResponse;
import com.latihan.model.responses.ResponseMessage;
import com.latihan.services.implemens.KursusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/kursusApp/v3/")
public class KursusController {
    @Autowired
    KursusServiceImpl kursusService;

    @PostMapping("kursusAdd")
    public ApiResponse<Object> addKursus(@RequestBody @Valid KursusPostDto kursusAdd){
        kursusService.addKursus(kursusAdd);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null);
    }

    @GetMapping("kursusGet")
    public ApiResponse<Object> getKursus(int pageNumber, int pageSize, String sort){
        Map<String, Object> data =  kursusService.getKursus(pageNumber, pageSize, sort);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data);
    }

    @GetMapping("kursusGet/{idKursus}")
    public ApiResponse<Object> getKursusById(@PathVariable UUID idKursus){
        Optional<Kursus> data = kursusService.getKursusById(idKursus);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(),data);
    }

    @PutMapping("kursusEdit")
    public ApiResponse<Object> editKursusById(@RequestBody Kursus kursus){
        kursusService.editKursusById(kursus);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_MODIFIED.getMessage(), null);
    }

    @DeleteMapping("kursusDelete/{idKursus}")
    public ApiResponse<Object> deleteKursusById(@PathVariable UUID idKursus){
        kursusService.deleteKursusById(idKursus);
        return ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null);
    }
}
