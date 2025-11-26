package com.codeanapp.project.mapper;

import com.codeanapp.project.model.Barang;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BarangMapper {

    void bulkInsertBarang(@Param("barangList") List<Barang> list);
}
