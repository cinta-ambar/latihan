package com.latihan.controller;

import com.latihan.dtos.kursus.KursusSiswaDto;
import com.latihan.model.entities.Siswa;
import com.latihan.model.responses.ApiResponse;
import com.latihan.model.responses.ResponseMessage;
import com.latihan.services.SiswaService;
import com.latihan.services.implemens.SiswaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/siswaApp/v2/")
public class SiswaController {
    @Autowired
    SiswaServiceImpl siswaService;

    @PostMapping("siswaAdd")
    public ApiResponse<Object> addGuru(@RequestBody Siswa siswaAdd){
        siswaService.addSiswa(siswaAdd);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(), null);
    }

    @GetMapping("siswaGet")
    public ApiResponse<Object> getSiswa(@RequestParam int pageNumber,
                                        @RequestParam int pageSize,
                                        @RequestParam String sort){
        Map<String, Object> data = siswaService.getSiswa(pageNumber, pageSize, sort);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data);
    }

    @GetMapping("siswaGet/{idSiswa}")
    public ApiResponse<Object> getSiswaById(@PathVariable UUID idSiswa){
        Optional<Siswa> data = siswaService.getSiswaById(idSiswa);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data);
    }

    @PutMapping("siswaEdit")
    public ApiResponse<Object> editSiswaById(@RequestBody Siswa siswa){
        siswaService.editSiswaById(siswa);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_MODIFIED.getMessage(), null);
    }

    @DeleteMapping("siswaDelete/{idSiswa}")
    public ApiResponse<Object> deleteSiswaById(@PathVariable UUID idSiswa){
        siswaService.deleteSiswaById(idSiswa);
        return ApiResponse.succes(HttpStatus.NO_CONTENT, ResponseMessage.RESOURCE_DELETE.getMessage(), null);
    }

    @GetMapping("siswa/Get/{keyword}")
    public ApiResponse<Object> getSiswaByNama(@PathVariable String keyword){
        List<Siswa> data = siswaService.getSiswaByNama(keyword);
        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_FETCHED.getMessage(), data);
    }

//    @PostMapping("siswaBelajar")
//    public ApiResponse<Object> addBelajar(@RequestBody KursusSiswaDto kursusSiswaDtoAdd){
//        siswaService.addBelajar(kursusSiswaDtoAdd);
//        return ApiResponse.succes(HttpStatus.OK, ResponseMessage.RESOURCE_CREATED.getMessage(),null);
//    }

}
