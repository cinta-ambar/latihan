package com.latihan.controller;

import com.latihan.model.entities.DaftarKursus;
import com.latihan.model.responses.ApiResponse;
import com.latihan.model.responses.ResponseMessage;
import com.latihan.services.implemens.DaftarKursusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("daftarKursus/")
public class DaftarKursusController {

    @Autowired
    DaftarKursusServiceImpl daftarKursusService;

    @PostMapping("daftarKursusAdd")
    public ApiResponse<Object> addDaftarKursus(@RequestBody DaftarKursus daftarKursusAdd){
        daftarKursusService.addDaftarKursus(daftarKursusAdd);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null);
    }
}
