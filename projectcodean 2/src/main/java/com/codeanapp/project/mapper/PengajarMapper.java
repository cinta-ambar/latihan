package com.codeanapp.project.mapper;

import com.codeanapp.project.model.Pengajar;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PengajarMapper {

    void insertPengajar(Pengajar pengajar);

    List<Pengajar> getAllPengajar();

    void deletePengajar(String idpengajar);
}
