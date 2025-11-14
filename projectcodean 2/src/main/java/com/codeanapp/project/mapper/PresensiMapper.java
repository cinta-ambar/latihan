package com.codeanapp.project.mapper;


import com.codeanapp.project.model.Presensi;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PresensiMapper {

    void insertPresensi(Presensi presensi);

    List<Presensi> getAllPresensi();

    void deletePresensi(String idpresensi);
}
