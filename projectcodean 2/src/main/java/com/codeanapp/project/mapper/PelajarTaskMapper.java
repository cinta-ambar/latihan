package com.codeanapp.project.mapper;

import com.codeanapp.project.model.PelajarTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PelajarTaskMapper {

    void insertPelajarTask(PelajarTask pelajarTask);

    List<PelajarTask> getAllPelajarTask(@Param("offset") int offset,
                                        @Param("pageSize") int pageSize,
                                        @Param("sort") String sort);
    int countPelajarTask();

    void deletePelajarTask(String idpelajartask);
}
