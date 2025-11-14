package com.codeanapp.project.service;


import com.codeanapp.project.mapper.PresensiMapper;
import com.codeanapp.project.model.Presensi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PresensiService {

    @Autowired
    private PresensiMapper presensiMapper;

    public void insertPresensi(Presensi presensi){
        if (presensi.getIdpresensi() == null || presensi.getIdpresensi().isEmpty()){
            presensi.setIdpresensi(UUID.randomUUID().toString());
        }
        presensiMapper.insertPresensi(presensi);
    }

    public List<Presensi> getAllPresensi(){
       List<Presensi> data = presensiMapper.getAllPresensi();
       return data;
    }

    public void deletePresensi(String idpresensi){
        presensiMapper.deletePresensi(idpresensi);
    }

}
