package com.codeanapp.project.service;

import com.codeanapp.project.exception.InvalidFormatException;
import com.codeanapp.project.mapper.PengajarMapper;
import com.codeanapp.project.model.Pengajar;
import com.codeanapp.project.model.enumm.JenisKelamin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PengajarService {

    @Autowired
    private PengajarMapper pengajarMapper;

    public void insertPengajar(Pengajar pengajar){
        if (pengajar.getIdpengajar() == null || pengajar.getIdpengajar().isEmpty()){
            pengajar.setIdpengajar(UUID.randomUUID().toString());
        }
        if (pengajar.getNamalengkap() == null || pengajar.getNamalengkap().isEmpty()){
            throw new InvalidFormatException("nama tidak boleh kosong");
        }
        if (pengajar.getNowa() == null || pengajar.getNowa().isEmpty()){
            throw new InvalidFormatException("nomer wa tidak boleh kosong");
        }
        if (pengajar.getJeniskelamin() == null || pengajar.getJeniskelamin().isEmpty()){
            throw new InvalidFormatException("gender tidak boleh kosong");
        }
        if (pengajar.getLulusan() == null || pengajar.getLulusan().isEmpty()){
            throw new InvalidFormatException("lulusan tidak boleh kosong");
        }
        String pilihan = pengajar.getJeniskelamin();
        switch (pilihan){
            case "l" :
                String a = JenisKelamin.PRIA_.getMessage();
                pengajar.setJeniskelamin(a);
                break;
            case "p" :
                String b = JenisKelamin.WANITA_.getMessage();
                pengajar.setJeniskelamin(b);
                break;
            default:
                String c = "pilihan tidak ditemukan";
                pengajar.setJeniskelamin(c);
        }

        pengajarMapper.insertPengajar(pengajar);
    }

    public List<Pengajar> getAllPengajar(){
        return pengajarMapper.getAllPengajar();
    }

    public void deletePengajar(String idpengajar){
        pengajarMapper.deletePengajar(idpengajar);
    }
}
