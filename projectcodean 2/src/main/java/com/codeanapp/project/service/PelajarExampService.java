package com.codeanapp.project.service;

import com.codeanapp.project.exception.InvalidFormatException;
import com.codeanapp.project.mapper.PelajarExampMapper;
import com.codeanapp.project.model.PelajarExamp;
import com.codeanapp.project.model.PelajarTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PelajarExampService {

    @Autowired
    private PelajarExampMapper pelajarExampMapper;

    public void insertPelajarExamp(PelajarExamp pelajarExamp){
        if (pelajarExamp.getIdpelajarexamp() == null || pelajarExamp.getIdpelajarexamp().isEmpty()){
            pelajarExamp.setIdpelajarexamp(UUID.randomUUID().toString());
        }
        if (pelajarExamp.getExampid() == null  || pelajarExamp.getExampid().isEmpty()){
            throw new InvalidFormatException("id examp tidak boleh kosong");
        }
        if (pelajarExamp.getPelajarid() == null || pelajarExamp.getPelajarid().isEmpty()){
            throw new InvalidFormatException("id pelajar tidak boleh kosong");
        }
        pelajarExampMapper.insertPelajarExamp(pelajarExamp);
    }

    public Map<String, Object> getAllPelajarExamp(int pageNumber, int pageSize, String sort){
        int offset = pageNumber * pageSize;
        List<PelajarExamp> data = pelajarExampMapper.getAllPelajarExamp(offset, pageSize, sort);

        int totalItems = pelajarExampMapper.countPelajarExamp();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("account", data);
        response.put("halaman", pageNumber);
        response.put("totalItems", totalItems);
        response.put("totalHalaman", totalPages);
        return response;
    }

    public void deletePelajarExamp(String idpelajarexamp){
        pelajarExampMapper.deletePelajarExamp(idpelajarexamp);
    }
}
