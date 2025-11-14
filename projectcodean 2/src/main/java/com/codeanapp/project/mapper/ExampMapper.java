package com.codeanapp.project.mapper;

import com.codeanapp.project.dto.ExampUpdateDto;
import com.codeanapp.project.model.Examp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExampMapper {

    void insertExamp(Examp examp);

    List<Examp> getAllExamp();

    void updateExamp(ExampUpdateDto exampUpdateDto);

    void deleteExamp(String idexamp);
}
