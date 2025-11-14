package com.codeanapp.project.mapper;

import com.codeanapp.project.dto.MateriUpdateDto;
import com.codeanapp.project.model.Materi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MateriMapper {

    void insertMateri (Materi materi);

    List<Materi> getAllMateri(@Param("offset") int offset,
                              @Param("pageSize") int pageSize,
                              @Param("sort") String sort);
    int countMateri();

    void updateMateri(MateriUpdateDto materiUpdateDto);

    void deleteMateri(String idmateri);
}
