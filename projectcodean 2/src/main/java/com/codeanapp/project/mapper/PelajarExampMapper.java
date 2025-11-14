package com.codeanapp.project.mapper;

import com.codeanapp.project.model.PelajarExamp;
import com.codeanapp.project.model.PelajarMateri;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PelajarExampMapper {

    void insertPelajarExamp(PelajarExamp pelajarExamp);

    List<PelajarExamp> getAllPelajarExamp(@Param("offset") int offset,
                                            @Param("pageSize") int pageSize,
                                            @Param("sort") String sort);
    int countPelajarExamp();

    void deletePelajarExamp(String idpelajarexamp);
}
