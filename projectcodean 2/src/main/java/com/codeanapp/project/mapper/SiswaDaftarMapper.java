package com.codeanapp.project.mapper;

import com.codeanapp.project.model.SiswaDaftar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SiswaDaftarMapper {

    void insertSiswaDaftar(SiswaDaftar siswaDaftar);

    List<SiswaDaftar> getAllSiswaDaftar(@Param("offset") int offset,
                                        @Param("pageSize") int pageSize,
                                        @Param("sort") String sort);
    int countSiswaDaftar();

    void deleteSiswaDaftar(String idsiswadaftar);



}
