package com.codeanapp.project.mapper;

import com.codeanapp.project.model.PelajarMateri;
import com.codeanapp.project.model.PelajarTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PelajarMateriMapper {

    void insertPelajarMateri(PelajarMateri pelajarMateri);

    List<PelajarMateri> getAllPelajarMateri(@Param("offset") int offset,
                                            @Param("pageSize") int pageSize,
                                            @Param("sort") String sort);
    int countPelajarMateri();

    void deletePelajarMateri(String idpelajarmateri);
}
