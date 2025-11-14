package com.codeanapp.project.service;

import com.codeanapp.project.dto.ExampUpdateDto;
import com.codeanapp.project.mapper.ExampMapper;
import com.codeanapp.project.model.Examp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExampService {

    @Autowired
    private ExampMapper exampMapper;

    public void insertExamp(Examp examp){
        if (examp.getIdexamp() == null || examp.getIdexamp().isEmpty()){
            examp.setIdexamp(UUID.randomUUID().toString());
        }
        exampMapper.insertExamp(examp);
    }

    public List<Examp> getAllExamp(){
        return exampMapper.getAllExamp();
    }

    public void updateExamp(ExampUpdateDto exampUpdateDto){
        exampMapper.updateExamp(exampUpdateDto);
    }

    public void deleteExamp(String idexamp){
        exampMapper.deleteExamp(idexamp);
    }
}
