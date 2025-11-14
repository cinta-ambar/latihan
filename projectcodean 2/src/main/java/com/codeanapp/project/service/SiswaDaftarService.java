package com.codeanapp.project.service;

import com.codeanapp.project.exception.InvalidFormatException;
import com.codeanapp.project.mapper.SiswaDaftarMapper;
import com.codeanapp.project.model.SiswaDaftar;
import com.codeanapp.project.model.enumm.JenisKelamin;
import com.codeanapp.project.model.enumm.PengetahuanKoding;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class SiswaDaftarService {

    @Autowired
    private SiswaDaftarMapper siswaDaftarMapper;

    public void addSiswaDaftar(SiswaDaftar siswaDaftar){
        if (siswaDaftar.getIdsiswadaftar() == null || siswaDaftar.getIdsiswadaftar().isEmpty()){
            siswaDaftar.setIdsiswadaftar(UUID.randomUUID().toString());
        }
        if (siswaDaftar.getNamalengkap() == null || siswaDaftar.getNamalengkap().isEmpty()){
            throw new InvalidFormatException("Nama tidak boleh kosong");
        }
        if (siswaDaftar.getNowa() == null){
            throw new InvalidFormatException("Nomer tidak boleh kosong");
        }
        if (siswaDaftar.getJeniskelamin() == null || siswaDaftar.getJeniskelamin().isEmpty()){
            throw new InvalidFormatException("Jenis kelamin tidak boleh kosong");
        }
        if (siswaDaftar.getNamasekolah() == null || siswaDaftar.getNamasekolah().isEmpty()){
            throw new InvalidFormatException("Nama sekolah tidak boleh kosong");
        }
        if (siswaDaftar.getJurusan() == null || siswaDaftar.getJurusan().isEmpty()){
            throw new InvalidFormatException("Jurusan tidak boleh kosong");
        }
        if (siswaDaftar.getPengetahuankoding() == null || siswaDaftar.getPengetahuankoding().isEmpty()){
            throw new InvalidFormatException("pengetahuan kodong tidak boleh kosong");
        }

        String pilihan = siswaDaftar.getJeniskelamin();
        switch (pilihan){
            case "l":
                String a = JenisKelamin.PRIA_.getMessage();
                siswaDaftar.setJeniskelamin(a);
                break;
            case "p":
                String b = JenisKelamin.WANITA_.getMessage();
                siswaDaftar.setJeniskelamin(b);
                break;
            default:
                String c = "Tuhan menciptakan jenis kelamin hanya 2: pria dan wanita";
                siswaDaftar.setJeniskelamin(c);
        }

        String pk = siswaDaftar.getPengetahuankoding();
        switch (pk){
            case "a" :
                String a = PengetahuanKoding.NOL_.getMessage();
                siswaDaftar.setPengetahuankoding(a);
                break;
            case "b" :
                String b = PengetahuanKoding.SEDANG_.getMessage();
                siswaDaftar.setPengetahuankoding(b);
                break;
            case "c" :
                String c = PengetahuanKoding.EKSPERT.getMessage();
                break;
            default:
                String d = "pilihan tidak ditemukan";
                siswaDaftar.setPengetahuankoding(d);
        }

        siswaDaftarMapper.insertSiswaDaftar(siswaDaftar);
    }

    public Map<String, Object> getAllSiswaDaftar(int pageNumber, int pageSize, String sort){
        int offset = pageNumber * pageSize;
        List<SiswaDaftar> data = siswaDaftarMapper.getAllSiswaDaftar(offset, pageSize, sort);

        int totalItems = siswaDaftarMapper.countSiswaDaftar();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("data", data);
        response.put("halaman", pageNumber);
        response.put("totalItems", totalItems);
        response.put("totalHalaman", totalPages);
        return response;

    }

    public void deleteSiswaDaftar(String idsiswadaftar){
        siswaDaftarMapper.deleteSiswaDaftar(idsiswadaftar);
    }
}
