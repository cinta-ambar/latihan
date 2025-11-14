package com.codeanapp.project.service;

import com.codeanapp.project.mapper.PelajarMateriMapper;
import com.codeanapp.project.model.PelajarMateri;
import com.codeanapp.project.model.PelajarTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PelajarMateriService {

    @Autowired
    private PelajarMateriMapper pelajarMateriMapper;

    public void insertPelajarMateri(PelajarMateri pelajarMateri){
        if (pelajarMateri.getIdpelajarmateri() == null || pelajarMateri.getIdpelajarmateri().isEmpty()){
            pelajarMateri.setIdpelajarmateri(UUID.randomUUID().toString());
        }
        pelajarMateriMapper.insertPelajarMateri(pelajarMateri);
    }

    public Map<String, Object> getAllPelajarMateri(int pageNumber, int pageSize, String sort){
        int offset = pageNumber * pageSize;
        List<PelajarMateri> data = pelajarMateriMapper.getAllPelajarMateri(offset, pageSize, sort);

        int totalItems = pelajarMateriMapper.countPelajarMateri();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("account", data);
        response.put("halaman", pageNumber);
        response.put("totalItems", totalItems);
        response.put("totalHalaman", totalPages);
        return response;
    }

    public void deletePelajarMateri(String idpelajarmateri){
        pelajarMateriMapper.deletePelajarMateri(idpelajarmateri);
    }
}
