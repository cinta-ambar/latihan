package com.codeanapp.project.service;

import com.codeanapp.project.dto.PelajarUpdateDto;
import com.codeanapp.project.mapper.PelajarMapper;
import com.codeanapp.project.model.Pelajar;
import com.codeanapp.project.model.enumm.JenisKelamin;
import com.codeanapp.project.model.enumm.PengetahuanKoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PelajarService {

    @Autowired
    private PelajarMapper pelajarMapper;

    public void insertPelajar(Pelajar pelajar){
        if (pelajar.getIdpelajar() == null || pelajar.getIdpelajar().isEmpty()){
            pelajar.setIdpelajar(UUID.randomUUID().toString());
        }
        String pilihan = pelajar.getJeniskelamin();
        switch (pilihan){
            case "l" :
                String a = JenisKelamin.PRIA_.getMessage();
                pelajar.setJeniskelamin(a);
                break;
            case "p" :
                String b = JenisKelamin.WANITA_.getMessage();
                pelajar.setJeniskelamin(b);
                break;
            default:
                String c = "pilihan tidak ditemukan";
                pelajar.setJeniskelamin(c);
        }
        String pilihan2 = pelajar.getPengetahuankoding();
        switch (pilihan2){
            case "a" :
                String a = PengetahuanKoding.NOL_.getMessage();
                pelajar.setPengetahuankoding(a);
                break;
            case "b" :
                String b = PengetahuanKoding.SEDANG_.getMessage();
                pelajar.setPengetahuankoding(b);
                break;
            case "c" :
                String c = PengetahuanKoding.EKSPERT.getMessage();
                pelajar.setPengetahuankoding(c);
                break;
            default:
                String d = "pilihan tidak ditemukan";
                pelajar.setPengetahuankoding(d);
        }
        pelajarMapper.insertPelajar(pelajar);
    }

    public Map<String, Object> getAllPelajar(int pageNumber, int pageSize, String sort){
        int offset = pageNumber * pageSize;
        List<Pelajar> data = pelajarMapper.getAllPelajar(offset, pageSize, sort);

        int totalItems = pelajarMapper.countPelajar();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("data", data);
        response.put("halaman", pageNumber);
        response.put("totalItems", totalItems);
        response.put("totalhalaman", totalPages);
        return response;
    }

    public void updatePelajar(PelajarUpdateDto pelajarUpdateDto){
        String pilihan = pelajarUpdateDto.getJeniskelamin();
        switch (pilihan){
            case "l" :
                String a = JenisKelamin.PRIA_.getMessage();
                pelajarUpdateDto.setJeniskelamin(a);
                break;
            case "p" :
                String b = JenisKelamin.WANITA_.getMessage();
                pelajarUpdateDto.setJeniskelamin(b);
                break;
            default:
                String c = "pilihan tidak ditemukan";
                pelajarUpdateDto.setJeniskelamin(c);
        }
        String pilihan2 = pelajarUpdateDto.getPengetahuankoding();
        switch (pilihan2){
            case "a" :
                String a = PengetahuanKoding.NOL_.getMessage();
                pelajarUpdateDto.setPengetahuankoding(a);
                break;
            case "b" :
                String b = PengetahuanKoding.SEDANG_.getMessage();
                pelajarUpdateDto.setPengetahuankoding(b);
                break;
            case "c" :
                String c = PengetahuanKoding.EKSPERT.getMessage();
                pelajarUpdateDto.setPengetahuankoding(c);
                break;
            default:
                String d = "pilihan tidak ditemukan";
                pelajarUpdateDto.setPengetahuankoding(d);
        }
        pelajarMapper.updatePelajar(pelajarUpdateDto);
    }

    public void deletePelajar(String idpelajar){
        pelajarMapper.deletePelajar(idpelajar);
    }
}
