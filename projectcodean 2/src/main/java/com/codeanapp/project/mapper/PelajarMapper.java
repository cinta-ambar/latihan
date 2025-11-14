package com.codeanapp.project.mapper;

import com.codeanapp.project.dto.PelajarUpdateDto;
import com.codeanapp.project.model.Pelajar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PelajarMapper {

    void insertPelajar(Pelajar pelajar);

    List<Pelajar> getAllPelajar(@Param("offset") int offset,
                                @Param("pageSize") int pageSize,
                                @Param("sort") String sort);

    int countPelajar();

    void updatePelajar(PelajarUpdateDto pelajarUpdateDto);

    void deletePelajar(String idpelajar);
}
