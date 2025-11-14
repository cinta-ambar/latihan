package com.codeanapp.project.service;

import com.codeanapp.project.exception.InvalidFormatException;
import com.codeanapp.project.mapper.PelajarTaskMapper;
import com.codeanapp.project.model.PelajarTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PelajarTaskService {

    @Autowired
    private PelajarTaskMapper pelajarTaskMapper;

    public void insertPelajarTask(PelajarTask pelajarTask){
        if (pelajarTask.getIdpelajartask() == null || pelajarTask.getIdpelajartask().isEmpty()){
            pelajarTask.setIdpelajartask(UUID.randomUUID().toString());
        }
        if (pelajarTask.getTaskid() == null  || pelajarTask.getTaskid().isEmpty()){
            throw new InvalidFormatException("id taks tidak boleh kosong");
        }
        if (pelajarTask.getPelajarid() == null || pelajarTask.getPelajarid().isEmpty()){
            throw new InvalidFormatException("id pelajar tidak boleh kosong");
        }
        pelajarTaskMapper.insertPelajarTask(pelajarTask);
    }

    public Map<String, Object> getAllPelajarTask(int pageNumber, int pageSize, String sort){
        int offset = pageNumber * pageSize;
        List<PelajarTask> data = pelajarTaskMapper.getAllPelajarTask(offset, pageSize, sort);

        int totalItems = pelajarTaskMapper.countPelajarTask();
        int totalPages = (int) Math.ceil((double) totalItems / pageSize);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("account", data);
        response.put("halaman", pageNumber);
        response.put("totalItems", totalItems);
        response.put("totalHalaman", totalPages);
        return response;
    }

    public void deletePelajarTask(String idpelajartask){
        pelajarTaskMapper.deletePelajarTask(idpelajartask);
    }
}
