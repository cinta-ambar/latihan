package com.codeanapp.project.service;

import com.codeanapp.project.dto.MateriUpdateDto;
import com.codeanapp.project.exception.InvalidFormatException;
import com.codeanapp.project.mapper.MateriMapper;
import com.codeanapp.project.model.Materi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class MateriService {

    @Autowired
    private MateriMapper materiMapper;

    public void insertMateri(Materi materi){
        if (materi.getIdmateri() == null || materi.getIdmateri().isEmpty()){
            materi.setIdmateri(UUID.randomUUID().toString());
        }
        if (materi.getStackid() == null || materi.getStackid().isEmpty()){
            throw new InvalidFormatException("id tidak boleh kosong");
        }
        materiMapper.insertMateri(materi);
    }

    public Map<String, Object> getAllMateri(int pageNumber, int pageSize, String sort){
        int offset = pageNumber * pageSize;
        List<Materi> data = materiMapper.getAllMateri(offset, pageSize, sort);

        int totalItems = materiMapper.countMateri();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("account", data);
        response.put("halaman", pageNumber);
        response.put("totalItems", totalItems);
        response.put("totalHalaman", totalPages);
        return response;
    }

    public void updateMateri(MateriUpdateDto materiUpdateDto){
        materiMapper.updateMateri(materiUpdateDto);
    }

    public void deleteMateri(String idmateri){
        materiMapper.deleteMateri(idmateri);
    }
}
