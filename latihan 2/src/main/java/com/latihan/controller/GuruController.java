package com.latihan.controller;

import com.latihan.model.entities.Guru;
import com.latihan.model.responses.ApiResponse;
import com.latihan.model.responses.ResponseMessage;
import com.latihan.services.implemens.GuruServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/guruApp/v1/")
public class GuruController {
    @Autowired
    private GuruServiceImpl guruService;

    @PostMapping("guruAdd")
    public ApiResponse<Object> addGuru(@RequestBody Guru guruAdd){
        guruService.addGuru(guruAdd);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null);
    }

    @GetMapping("guruGet")
    public ApiResponse<Object> getGuru(int pageNumber, int pageSize, String sort){
        Map<String, Object> data =  guruService.getGuru(pageNumber, pageSize, sort);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data);
    }

    @GetMapping("guruGet/{idGuru}")
    public ApiResponse<Object> getGuruById(@PathVariable UUID idGuru){
        Optional<Guru> data = guruService.getGuruById(idGuru);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data);
    }

    @PutMapping("guruEdit")
    public ApiResponse<Object> editGuruById(@RequestBody Guru guru){
        Guru data = guruService.editGuruById(guru);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_MODIFIED.getMessage(), null);
    }

    @DeleteMapping("guruDelete/{idGuru}")
    public ApiResponse<Object> deleteGuruById(@PathVariable UUID idGuru){
        guruService.deleteGuruById(idGuru);
        return ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null);
    }
}
